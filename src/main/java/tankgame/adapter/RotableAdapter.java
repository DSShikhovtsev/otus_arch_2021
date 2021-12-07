package tankgame.adapter;

import tankgame.actions.Rotable;
import tankgame.exception.CoreException;
import tankgame.utils.UObject;

import java.util.Vector;

public class RotableAdapter implements Rotable {

    private final static String ANGULAR_VELOCITY = "angularVelocity";
    private final static String DIRECTION = "direction";

    private final UObject object;

    public RotableAdapter(UObject object) {
        this.object = object;
    }

    //todo вынести обработку ошибок в аспекты
    @Override
    public Vector<Integer> getAngularVelocity() {
        Vector<Integer> angularVelocity;
        try {
            angularVelocity = (Vector<Integer>) object.getProperty(ANGULAR_VELOCITY);
        } catch (ClassCastException exception) {
            throw new CoreException(exception.getMessage());
        }
        return angularVelocity;
    }

    @Override
    public Vector<Integer> getDirection() {
        Vector<Integer> direction;
        try {
            direction = (Vector<Integer>) object.getProperty(DIRECTION);
        } catch (ClassCastException exception) {
            throw new CoreException(exception.getMessage());
        }
        return direction;
    }

    @Override
    public void setDirection(Vector<Integer> direction) {
        object.setProperty(DIRECTION, direction);
    }

    @Override
    public Integer maxDirection() {
        Integer maxDirections;
        try {
            maxDirections = (Integer) object.getProperty(DIRECTION);
        } catch (ClassCastException exception) {
            throw new CoreException(exception.getMessage());
        }
        return maxDirections;
    }
}
