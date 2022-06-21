package TestNG_Practise_TestNG_Parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScript {
	@Test 
	@Parameters({ "sUsername", "sPassword" })
	public void test(String sUsername, String sPassword) {
	    //Statements that use sUsername and sPassword.
	}
}
