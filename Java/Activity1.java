package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car ertiga =new Car();
        ertiga.make=2020;
        ertiga.color="Grey";
        ertiga.transmission="Manual";

        ertiga.Displaycharacteristics();
        ertiga.accelarate();
        ertiga.brake();
    }

    public static class Car {
        String color;
        String transmission;
        int make;
        int tyres;
        int doors;

        public Car() {
            tyres= 4;
            doors= 4;
        }

        public void Displaycharacteristics() {
           System.out.println("colour:" + color);
           System.out.println("transmission:" + transmission);
           System.out.println("make:" + make);
           System.out.println("tyres:" + tyres);
           System.out.println("doors:" + doors);
       }
        public void accelarate() {
            System.out.println("Car is moving forward");
        }
        public void brake() {
            System.out.println("Car is stopped");
        }
    }
}
