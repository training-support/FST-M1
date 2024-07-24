
import java.lang.reflect.Array;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Activity4
{
    @Test
    void GroupAssertionTester()
    {
        String[]  IBMOfficesAtBengalure = {"Manyatha", "BCIT", "EGL", "SA", "FTP"};
        String EsstLoc = "FTP";
        String Cental = "EGL";

        System.out.println(IBMOfficesAtBengalure);
        for (int i = 0;i<IBMOfficesAtBengalure.length;i++)
        {
            System.out.println(IBMOfficesAtBengalure[i]);
        }
        //assertAll("IBMOffices"
        //() -> assertEquals("EGL", EsstLoc),
        //assertEquals("BCIT", Cental)
        Object obj = null;
        assertAll(
                "heading",
                () -> assertEquals(5, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("Guava", "JAVA".toLowerCase()),
                () -> assertNull(obj, "obj is null")
        );

    }

}
