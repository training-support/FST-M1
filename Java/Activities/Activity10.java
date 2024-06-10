package Activity;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        
        hs.add("var1");
        hs.add("var2");
        hs.add("var3");
        hs.add("var4");
        hs.add("var5");
        hs.add("var6");
        
        System.out.println("Size of HashSet: " + hs.size());
        
        //Remove element
        System.out.println("Removing var5 from HashSet: " + hs.remove("var5"));
       
        
        if(hs.remove("var7")) {
        	System.out.println("var7 removed from the Set");
        } else {
        	System.out.println("var7 is not present in the Hash Set");
        }
        
       
        System.out.println("Checking if var1 is present: " + hs.contains("var1"));
        
        System.out.println("Updated HashSet: " + hs);
    }
}
