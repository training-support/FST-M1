package Activity;

public class CustomException extends Exception{
	
	private String message;
	
	public CustomException(String s) {
		this.message = s;
	}
	
	@Override
	public String getMessage() {
	    return message;
	}
	

}
