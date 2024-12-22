package Activities;

class CustomException extends Exception
{
	private String message = null;
	
	public CustomException(String message)
	{
		this.message = message;
	}
	
	@Override
	
	public String getMessage()
	{
		return message;
	}
	
	}
public class Activity8 {

	public static void main(String[] args) {
	
		try {
			
			Activity8.exceptionTest("Will print to Console");
			
			Activity8.exceptionTest(null);
			
			Activity8.exceptionTest("Won't execute");
			
		} catch (CustomException ex)
		{
			System.out.println("Inside catch block: " + ex.getMessage());
		}	
	}
	
	static void exceptionTest(String str) throws CustomException
	{
		if(str==null)
		{
			throw new CustomException("String value is null");
		}
		else
		{
			System.out.println(str);
		}
	}

}