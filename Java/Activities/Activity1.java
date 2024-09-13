public class Activity {
    public static void main(String[] args){
        Car carName = new Car();
        carName.make=2014;
        carName.color="Black";
        carName.transmission="Manual";

        carName.displayCharacterstics();
        carName.accelerate();
        carName.brake();
    }

}
