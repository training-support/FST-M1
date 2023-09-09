package Activities;
abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() {
        return title;
    }
    static class MyBook extends Book {
        public void setTitle(String s) {
            title = s;
        }
    }
}

    public class Activity5 {
        public static void main(String[] args) {
            String title = "Atomic Behaviour";
            Book newNovel = new Book.MyBook();
            newNovel.setTitle(title);
            System.out.println("The title of the book is: " + newNovel.getTitle());
        }
}
