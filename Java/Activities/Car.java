package Activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car() {
        tyres = 4;
        doors = 4;
    }
        public void displayCharacterstics() {
            System.out.println("Color of the Car: " +color);
            System.out.println("Manufacture date of the Car: " +make);
            System.out.println("Transmission of the Car: " +transmission);
            System.out.println("Number of doors in the car: " +doors);
            System.out.println("Number of tyres in the car: " +tyres);
        }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }
    public void brake() {
        System.out.println("Car has stopped.");

    }
}
