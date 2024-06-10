package Activity;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            Activity8.exceptionTest("String is available to print");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("This step will not be executed since exception is thrown on previous step");
        } catch(CustomException e) {
            System.out.println("Inside catch block: " + e.getMessage());
        }
		
		
		}
	public static  void exceptionTest(String str) throws CustomException{
		if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
		}
		

}
