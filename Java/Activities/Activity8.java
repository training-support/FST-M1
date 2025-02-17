package activities;

class CustomException extends Exception {
	private String message= null;
	
	public CustomException(String message) {
		this.message=message;
		
	}
	public String getMessage(){
		return message;
	}
	
}

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Method call with Correct input
			Activity8.exceptionTest("Will print to control");
			//Method call with incorrect input
			Activity8.exceptionTest(null);
			
			Activity8.exceptionTest("Won't execute");
	}catch(CustomException ex) {
		
		ex.printStackTrace();
		
		System.out.println("Inside catch block:" +ex.getMessage());
		}
	}

	static void exceptionTest(String str)throws CustomException {
		// TODO Auto-generated method stub
		if(str == null) {
			throw new CustomException("String Value is null");
		}
		else {
			System.out.println(str);
		}
	}

}
