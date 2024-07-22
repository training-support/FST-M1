package activities;

public class Activity7 {
    public static void main(String[] args){
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println("Current Speed is = "+mb.currentSpeed);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}

interface BicycleParts {
    //Number of gears on bicycle
    public int gears = 0;
    //Max speed of bicycle
    public int speed = 0;
}

interface BicycleOperations{
    //how much to slow down the bicycle by.
    public void applyBrake(int decrement);
    //how much to speed up the bicycle by
    public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations{
    public int gears;
    public int currentSpeed;
    public Bicycle(int gears, int currentSpeed){
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int decrement){
        currentSpeed = currentSpeed-decrement;
        System.out.println("Decremented Speed is = "+ currentSpeed);
    }

    public void speedUp(int increment){
        currentSpeed = currentSpeed+ increment;
        System.out.println("Incremented Speed is = "+ currentSpeed);
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle{
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int seatHeight){
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    @Override
    public String bicycleDesc() {
        return("Seat Height is = "+seatHeight);
    }
}