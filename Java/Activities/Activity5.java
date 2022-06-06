package activities;

public class Activity5 {
 
	public static void main(String[] args)
	
	{ 
		myBook b =new myBook();
	    b.setTitle("Game of thrones");
	    String bookTitle = b.getTitle();
	    System.out.println("The Title of book is:" +bookTitle);
	}
}


 abstract class Book
{ 
	 String title;

	abstract void setTitle (String title);
	
	String getTitle()
	{
		return title;
	}
	
}
 
 
 class myBook extends Book
 {
	 
	 public void setTitle(String x) 
	 {
		    title = x;
	 }
  }
 

