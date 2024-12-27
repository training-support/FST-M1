package activities;

public class Activity2 {

	public static void main(String[] args) {
		// creates the object for the class to call the functions exist in this class
		Activity2 actobj=new Activity2();
		int[] numarray= {10, 77, 10, 54, -11, 10};
		//set the numbers to serach for
		 int searchNum=10;
		 
		int fixedsum=30;
		
		//call the result function and print the result
		System.out.println("Result :"+actobj.result(numarray,searchNum,fixedsum));
	}

	public boolean result(int[] numarray, int searchNum, int fixedsum) {
		// TODO Auto-generated method stub
		int tempsum =0;
		for(int number:numarray) {
			//check if the number is search Num
			if(number == searchNum) {
				//Add the Value
				tempsum=tempsum+searchNum;
				
				//tempsum +=searchNum;
			}
			
			//check if tempsum is greater than fixedNum
			if(tempsum > fixedsum) {
				//condition fails, break loop
				break;
			}
		}
		return fixedsum == tempsum;
	}

}
