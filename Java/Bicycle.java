package activities;

interface BicycleParts{
    public int gears=0;
    public int speed=0;
}
interface BicycleOperations{
    public void applyBrake(int d);
    public void speedUp(int i);
}

public class Bicycle implements BicycleOperations,BicycleParts{
    public int gears;
    public int speed;
    public Bicycle(int a, int b){
        gears=a;
        speed=b;
    }
    public void applyBrake(int x){
        speed-=x;
        System.out.println("Speed:"+speed);
    }
    public void speedUp(int x){
        speed+=x;
        System.out.println("Speed:"+speed);
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
    }
}
