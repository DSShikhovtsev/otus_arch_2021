package tankgame.command;

import tankgame.utils.UObject;

public class BurnFuelCommand implements Command {

    private final UObject object;
    private final static String FUEL = "fuel";
    private final static String BURN_SPEED = "burn_speed";

    public BurnFuelCommand(UObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        object.setProperty(FUEL, (Integer) object.getProperty(FUEL) - (Integer) object.getProperty(BURN_SPEED));
    }
}
