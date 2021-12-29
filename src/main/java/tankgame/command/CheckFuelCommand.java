package tankgame.command;

import tankgame.exception.CommandException;
import tankgame.utils.UObject;

public class CheckFuelCommand implements Command {

    private final UObject object;
    private final static String FUEL = "fuel";
    private final static String BURN_SPEED = "burn_speed";

    public CheckFuelCommand(UObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        if (((Integer) object.getProperty(FUEL)) < (Integer) object.getProperty(BURN_SPEED)) {
            throw new CommandException("have no fuel to move");
        }
    }
}
