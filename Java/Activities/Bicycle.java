package Activity;

public class Bicycle {

	public int gears;
    public int currentSpeed;
    
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Current speed: " + currentSpeed);
    }

    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Current speed: " + currentSpeed);
    }

    //Method to print info of Bicycle
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}
