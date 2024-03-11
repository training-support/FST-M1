package Activities.Activity5;

public class Activity5 {
    public static void main(String []args) {
        String title = "Hover Car Racer";

        Book newNovel = new MyBook();

        newNovel.setTitle(title);

        System.out.println("The title is: " + newNovel.getTitle());
    }
}
