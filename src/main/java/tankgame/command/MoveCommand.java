package tankgame.command;

import tankgame.adapter.MovableAdapter;
import tankgame.services.MoveService;
import tankgame.utils.UObject;

public class MoveCommand implements Command {

    private final UObject object;
    private final MoveService service;

    public MoveCommand(UObject object) {
        this.object = object;
        this.service = new MoveService(new MovableAdapter(object));
    }

    @Override
    public void execute() {
        service.execute();
    }
}
