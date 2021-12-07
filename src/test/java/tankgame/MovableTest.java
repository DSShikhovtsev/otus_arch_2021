package tankgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tankgame.adapter.MovableAdapter;
import tankgame.exception.CoreException;
import tankgame.model.Tank;
import tankgame.services.MoveService;
import tankgame.utils.UObject;

import org.junit.jupiter.api.Assertions;

import java.util.Vector;

public class MovableTest {

    private UObject object;
    private MovableAdapter adapter;
    private MoveService moveService;

    @BeforeEach
    void setUp() {
        this.object = new Tank();
        this.adapter = new MovableAdapter(this.object);
        this.moveService = new MoveService(this.adapter);
    }

    @Test
    void moveObjectTest() {
        Vector<Integer> position = new Vector<>();
        position.add(12);
        position.add(5);
        object.setProperty("position", position);
        Vector<Integer> velocity = new Vector<>();
        velocity.add(-7);
        velocity.add(3);
        object.setProperty("velocity", velocity);
        this.moveService.execute();
        Vector<Integer> newPosition = new Vector<>();
        newPosition.add(5);
        newPosition.add(8);
        Assertions.assertEquals(object.getProperty("position"), newPosition);
    }

    @Test
    void moveWithoutPosition() {
        Vector<Integer> velocity = new Vector<>();
        velocity.add(-7);
        velocity.add(3);
        object.setProperty("velocity", velocity);
        Assertions.assertThrows(CoreException.class, () -> this.moveService.execute());
    }

    @Test
    void moveWithoutVelocity() {
        Vector<Integer> position = new Vector<>();
        position.add(12);
        position.add(5);
        object.setProperty("position", position);
        Assertions.assertThrows(CoreException.class, () -> this.moveService.execute());
    }
}
