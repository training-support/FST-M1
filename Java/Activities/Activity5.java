package Activities;

//Abstract class
abstract class Book {
	
  String title;
  //Abstract method
  public abstract void setTitle(String title);
  
  //Concrete method
  public String getTitle() {
      return this.title;
  }
}

class MyBook extends Book {
  //Define abstract method
  public void setTitle(String title) {
      this.title = title;
  }
}

class MyBook2 extends Book {
	  //Define abstract method
	  public void setTitle(String title) {
	      if(title.length() > 3)
	      {
	    	  System.out.println("Title is too small");
	      }
	      else
	      {
	    	  this.title = title;
	      }
	  }
	}

public class Activity5 {
  
  public static void main(String []args) {
      //Initialize title of the book
      String title = "Parcy Jakson and the Lightening Thief";
      //Create object for MyBook
      Book bookObj = new MyBook();
      //Set title
      bookObj.setTitle(title);
      
      //Print result
      System.out.println("The title is: " + bookObj.getTitle());
  }
}