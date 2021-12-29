package tankgame.command;

import tankgame.exception.CommandException;

import java.util.List;

public class MacroCommand implements Command {

    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        try {
            commands.forEach(Command::execute);
        } catch (RuntimeException e) {
            throw new CommandException("error during macro command");
        }

    }
}
