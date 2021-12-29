package tankgame;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tankgame.command.*;
import tankgame.exception.CommandException;
import tankgame.model.Tank;
import tankgame.utils.UObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {

    @Test
    public void burnFuelCommandTest() {
        // хотел на моках, но быстро разобраться не получилось, потом почитаю еще
        UObject object = new Tank();
        object.setProperty("fuel", 5);
        object.setProperty("burn_speed", 2);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(object);
        burnFuelCommand.execute();
        assertEquals(object.getProperty("fuel"), 3);
    }

    @Test
    public void checkFuelCommandTest() {
        UObject object = Mockito.mock(UObject.class);
        when(object.getProperty("fuel")).thenReturn(2);
        when(object.getProperty("burn_speed")).thenReturn(5);
        CheckFuelCommand command = new CheckFuelCommand(object);
        assertThrows(CommandException.class, command::execute);
    }

    @Test
    public void macroCommandTest() {
        UObject object = new Tank();
        List<Command> commands = new ArrayList<>();
        commands.add(new CheckFuelCommand(object));
        commands.add(new BurnFuelCommand(object));
        object.setProperty("fuel", 5);
        object.setProperty("burn_speed", 2);

        commands.add(new MoveCommand(object));
        Vector<Integer> position = new Vector<>();
        position.add(12);
        position.add(5);
        object.setProperty("position", position);
        Vector<Integer> velocity = new Vector<>();
        velocity.add(-7);
        velocity.add(3);
        object.setProperty("velocity", velocity);
        Vector<Integer> newPosition = new Vector<>();
        newPosition.add(5);
        newPosition.add(8);

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();

        assertEquals(object.getProperty("fuel"), 3);
        assertEquals(object.getProperty("position"), newPosition);
    }

    @Test
    public void moveForwardWithFuelCommand() {
        UObject object = new Tank();
        object.setProperty("fuel", 5);
        object.setProperty("burn_speed", 2);
        Vector<Integer> position = new Vector<>();
        position.add(12);
        position.add(5);
        object.setProperty("position", position);
        Vector<Integer> velocity = new Vector<>();
        velocity.add(-7);
        velocity.add(3);
        object.setProperty("velocity", velocity);
        Vector<Integer> newPosition = new Vector<>();
        newPosition.add(5);
        newPosition.add(8);

        MoveForwardWithFuelCommand moveForwardWithFuelCommand = new MoveForwardWithFuelCommand(object);
        moveForwardWithFuelCommand.execute();

        assertEquals(object.getProperty("fuel"), 3);
        assertEquals(object.getProperty("position"), newPosition);
    }
}
