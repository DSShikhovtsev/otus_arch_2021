package tankgame.command;

import tankgame.exception.CoreException;
import tankgame.exception.StopCommandException;

import java.util.concurrent.ArrayBlockingQueue;

public class CommandExecutor  {

    private final Thread thread;
    private final ArrayBlockingQueue<Command> queue;

    private boolean isWorked;

    public boolean isWorked() {
        return isWorked;
    }

    public CommandExecutor(ArrayBlockingQueue<Command> queue) {
        this.queue = queue;
        this.thread = new Thread(() -> {
            isWorked = true;
            while (isWorked) {
                try {
                    queue.take().execute();
                } catch(StopCommandException e) {
                    isWorked = false;
                } catch (CoreException | InterruptedException e) {
                    //some logs
                }
            }
        });
        this.thread.start();
    }
}
