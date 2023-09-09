package Activities;

interface BicycleParts {
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations {
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
class Bicycle implements BicycleParts, BicycleOperations {
    public int gears;
    public int currentSpeed;
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed-decrement;
        System.out.println("Current speed: " + currentSpeed);
    }

    public void speedUp(int increment) {
        currentSpeed = currentSpeed+increment;
        System.out.println("Current speed: " + currentSpeed);
    }
    public String bicycleDesc() {
        return("No of gears in the bicycle are "+ gears + "\n Speed of the bicycle is " + currentSpeed);
    }
}
class MountainBike extends Bicycle {
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int height) {
        super(gears, currentSpeed);
        seatHeight = height;
    }
    public void setHeight(int heightValue) {
        seatHeight = heightValue;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nHeight of the seat is: " + seatHeight);
    }
}

public class Activity7 {
    public static void main(String[] args) {
        MountainBike bike = new MountainBike(3, 0, 25);
        System.out.println(bike.bicycleDesc());
        bike.speedUp(20);
        bike.applyBrake(5);
    }
}
