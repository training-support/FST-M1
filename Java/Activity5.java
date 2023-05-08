package activities;

public class Activity5 {
    public static void main(String[] args) {
        String title="Midnight Sun";
        MyBook newNovel= new MyBook();
        //Set title
        newNovel.setTitle(title);
        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }

    abstract static class Book {
        String title;
        abstract void setTitle(String s);
        public String getTitle() {
            return title;
        }
    }

    public static class MyBook extends Book {
        public void setTitle(String s) {
            title = s;
        }


    }
}
