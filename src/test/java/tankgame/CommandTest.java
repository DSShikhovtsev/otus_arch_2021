package tankgame;

import org.apache.commons.lang3.ThreadUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tankgame.command.Command;
import tankgame.command.CommandExecutor;
import tankgame.exception.StopCommandException;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ArrayBlockingQueue;

public class CommandTest {

    @Test
    public void CommandStopTest() {
        ArrayBlockingQueue<Command> queue = Mockito.mock(ArrayBlockingQueue.class);
        CommandExecutor executor = null;
        try {
            when(queue.take()).thenThrow(new StopCommandException(""));
            queue.add(System.out::println);
            executor = new CommandExecutor(queue);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(executor.isWorked());
    }

    @Test
    public void ThreadRunningTest() {
        ArrayBlockingQueue<Command> queue = Mockito.mock(ArrayBlockingQueue.class);
        int threadSize = ThreadUtils.getAllThreads().size();
        try {
            when(queue.take()).thenReturn(System.out::println);
            queue.add(System.out::println);
            new CommandExecutor(queue);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(threadSize + 1, ThreadUtils.getAllThreads().size());
    }
}
