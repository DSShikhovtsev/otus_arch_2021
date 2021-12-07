package tankgame.services;

import tankgame.actions.Rotable;

import java.util.Vector;

public class RotateService {

    private final Rotable rotable;

    public RotateService(Rotable rotable) {
        this.rotable = rotable;
    }

    public void execute() {
        Vector<Integer> direction = rotable.getDirection();
        Vector<Integer> angularVelocity = rotable.getAngularVelocity();
        for (int i = 0; i < direction.size(); i++) {
            direction.set(i, (direction.get(i) + angularVelocity.get(i)) % rotable.maxDirection());
        }
        rotable.setDirection(direction);
    }
}
