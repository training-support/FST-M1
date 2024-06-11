package JunitTestclasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
   
    static ArrayList<String> list;
 
    
    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("data1"); 
        list.add("data2"); 
    }
 
    
    @Test
    public void insertTest() {
       
        assertEquals(2, list.size(), "Wrong size");
                
        list.add(2, "data3");
       
        assertEquals(3, list.size(), "Wrong size");
 
       
        assertEquals("data1", list.get(0), "Wrong element");
        assertEquals("data2", list.get(1), "Wrong element");
        assertEquals("data3", list.get(2), "Wrong element");
    }
 
   
    @Test
    public void replaceTest() {
       
                
        assertEquals(2, list.size(), "Wrong size");
       
        list.add(2, "data3new");
        
        assertEquals(3, list.size(), "Wrong size");
        
        list.set(1, "data2new");
        
        assertEquals("data1", list.get(0), "Wrong element");
        assertEquals("data2new", list.get(1), "Wrong element");
        assertEquals("data3new", list.get(2), "Wrong element");
    }
}