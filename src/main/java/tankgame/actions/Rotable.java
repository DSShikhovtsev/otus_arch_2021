package tankgame.actions;

import java.util.Vector;

public interface Rotable {

    Vector<Integer> getAngularVelocity();
    Vector<Integer> getDirection();
    void setDirection(Vector<Integer> direction);
    Integer maxDirection();
}
