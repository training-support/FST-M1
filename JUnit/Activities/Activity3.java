import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Activity3
{
    @Test
    void addNumbers()
    {
        Calculator calculator = new Calculator();

        assertEquals(60, calculator.add(4,2),"You did not do math correctly");

    }
}
