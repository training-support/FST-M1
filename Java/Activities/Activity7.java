package activities;

public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3,0,25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }

    public static class MountainBike extends Bicycle{
        public int seatheight;

        public MountainBike(int a,int b,int c){
            super(a,b);
            seatheight=c;
        }

        public void setHeight(int newValue) {
            seatheight = newValue;
        }
        public String bicycleDesc() {
            return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
        }
    }
}
