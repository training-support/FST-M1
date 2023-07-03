package Activities;

public class Activity1 {
    public static void main(String[] args){
      Car car = new Car(4, 4);
      car.make = 2014;
      car.transmission = "Manual";
      car.color = "Black";
      car.displayCharacteristics();
      car.accelerate();
      car.brake();
    }
}
