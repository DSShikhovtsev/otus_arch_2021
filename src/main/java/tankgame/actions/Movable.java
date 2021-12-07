package tankgame.actions;

import java.util.Vector;

public interface Movable {

    Vector<Integer> getPosition();
    void setPosition(Vector<Integer> position);
    Vector<Integer> getVelocity();
}
