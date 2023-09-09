package Activities;
interface Addable {
    int add(int num1, int num2);
}
public class Activity12 {
    public static void main(String[] args) {
        Addable ad1 = (a, b) -> (a + b);
       Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println("Result1: " +ad1.add(29, 41));
        System.out.println("Result2: " +ad2.add(782, 90));
    }
}
