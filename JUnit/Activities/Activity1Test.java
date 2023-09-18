package Activity;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1Test {
    // Test fixtures
    static ArrayList<String> list;

    // Initialize test fixtures before each test method
    @BeforeAll
    static void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }
    @Test
    public void insertTest() {
        assertEquals(2, list.size(), "Wrong size");
        list.add(2, "Gamma");
        assertEquals(3, list.size(), "Wrong size");

        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("Gamma", list.get(2), "Wrong element");
    }
    @Test
    public void replaceTest() {
        list.set(1, "Ford");
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("Ford", list.get(1), "Wrong element");

    }
}
