package activities;

    abstract class Book {
        String BookTitle;
        abstract void setTitle(String S);

        String getTitle()
        {
            return BookTitle;
        }
    }

    class MyBook extends Book {
        public void setTitle(String S) {
            BookTitle = S;
        }
        }


public class activity5 {
        public static void main (String [] args) {

            String BookTitle = "Racing Cars ";
            Book newNovel = new MyBook();
            newNovel.setTitle(BookTitle);
            System.out.println("The Book title is: " + newNovel.getTitle());
                }
            }
