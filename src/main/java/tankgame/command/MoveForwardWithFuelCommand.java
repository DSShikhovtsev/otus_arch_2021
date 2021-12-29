package tankgame.command;

import tankgame.utils.UObject;

import java.util.ArrayList;
import java.util.List;

public class MoveForwardWithFuelCommand implements Command {

    private final UObject object;

    public MoveForwardWithFuelCommand(UObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        List<Command> commands = new ArrayList<>();
        commands.add(new CheckFuelCommand(object));
        commands.add(new BurnFuelCommand(object));
        commands.add(new MoveCommand(object));

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();
    }
}
