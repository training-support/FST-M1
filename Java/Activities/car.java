package Activities;

public class car {
    private String color;
    private String transmission;
    private int make;
    private final int tyres = 4;
    private final int doors = 4;

    public car(String color, String transmission, int make)
    {
        this.color = color;
        this.transmission = transmission;
        this.make = make;
    }

    public void displayCharacteristics()
    {
        System.out.println("car color:" +color);
        System.out.println("transmission:" +transmission);
        System.out.println("make:" +make);
        System.out.println("No of tyres:" +tyres);
        System.out.println("No.of doors:" +doors);
    }

    public void accelerate()
    {
        System.out.println("car is moving forward!");
    }

    public void brake()
    {
        System.out.println("car has stopped.");
    }
}
