package tankgame.services;

import tankgame.actions.Movable;
import tankgame.exception.CoreException;

import java.util.Vector;

public class MoveService {

    private final Movable movable;

    public MoveService(Movable movable) {
        this.movable = movable;
    }

    public void execute() {
        Vector<Integer> position = movable.getPosition();
        Vector<Integer> velocity = movable.getVelocity();
        if (position == null || velocity == null) throw new CoreException("Property is missing");
        for (int i = 0; i < position.size(); i++) {
            position.set(i, position.get(i) + velocity.get(i));
        }
        movable.setPosition(position);
    }
}
