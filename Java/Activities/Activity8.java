package activities;

public class Activity8 {

	public static void main (String[] args)
	{ try {
	    Activity8.exceptionTest("Will print to console");
	    Activity8.exceptionTest(null);
	    }catch(CustomException Ex) {
        System.out.println("Inside catch block: " + Ex.getMessage());
        }
	}
	 static void exceptionTest(String str) throws CustomException {
	        if(str == null) {
	            throw new CustomException("String value is null");
	           }
	        else {
	               System.out.println(str);
	             }
	        
	     }   
	
}

class CustomException extends Exception
{
	private String message= null;
	
	CustomException(String message)
	{
		this.message=message;
		System.out.println("The Message passed is :" +message);
	}
	
	@Override
	public String getMessage() {
	    return message;
	}
	
	
}