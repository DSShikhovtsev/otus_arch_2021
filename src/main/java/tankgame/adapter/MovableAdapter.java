package tankgame.adapter;

import tankgame.actions.Movable;
import tankgame.exception.CoreException;
import tankgame.utils.UObject;

import java.util.Vector;

public class MovableAdapter implements Movable {

    private final static String POSITION = "position";
    private final static String VELOCITY = "velocity";

    private final UObject object;

    public MovableAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public Vector<Integer> getPosition() {
        Vector<Integer> position;
        try {
            position = (Vector<Integer>) object.getProperty(POSITION);
        } catch (ClassCastException exception) {
            throw new CoreException(exception.getMessage());
        }
        return position;
    }

    @Override
    public void setPosition(Vector<Integer> position) {
        object.setProperty(POSITION, position);
    }

    @Override
    public Vector<Integer> getVelocity() {
        Vector<Integer> velocity;
        try {
            velocity = (Vector<Integer>) object.getProperty(VELOCITY);
        } catch (ClassCastException exception) {
            throw new CoreException(exception.getMessage());
        }
        return velocity;
    }
}
