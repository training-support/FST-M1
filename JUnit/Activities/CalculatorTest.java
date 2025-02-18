package examples;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;



public class CalculatorTest {
	
	Calculator cal=new Calculator();
	
	@Test
	public void addTest(){
		
		//Perform the add function to get the ACTUAl Val
		int result1=cal.add(10,20);
		int result2=cal.add(15,15);
		int result3=cal.add(25,5);
		//Perform the Assertion function to verify the result Val
		//assertEquals(30,result);
		//Add a assertion statement to verify against EXPECTED result
		assertAll(
				()->assertEquals(30,result1),
				()->assertEquals(30,result2),
				()->assertEquals(30,result3)
				);
	}
	@Test
	public void multiplyTest(){
		//Perform the multiply function to get the ACTUAl Val
		int result1=cal.multiply(10,3);
		//Perform the Assertion function to verify the result Val
		assertEquals(30,result1);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {10,20,25,100})
	public void paramSqrTest(int num) {
		//perform the add function to get the ACTUAL result
		int result=cal.square(num);
		
		//Add a assertion statement to verify against EXPECTED result
		assertEquals(num*num , result);
	}
	
	@ParameterizedTest
	@CsvSource({
	    "10,90", 
	    "20, 80",
	    "50, 50"
	})
	public void paramAddTest(int num1 , int num2) {
		int result4= cal.add(num1, num2);
		assertEquals(100, result4);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(files= "src/test/resources/input.csv", nullValues = {"N/A", "N/A", "-"})
	public void AggregateTest(ArgumentsAccessor args) {
		System.out.println(args.getString(0) + "has only" + (args.getInteger(3)+3) + "sick days remaining");
	}
	

}
