package FSTJava.Activities;

public class Activity3 {

    public static void main(String args[]) {
        double seconds = 1000000000;

        double EarthSeconds = 565633;
        double MercurySeconds = 12.33344;
        double VenusSeconds = 87.33334;
        double MarsSeconds = 6.885435;
        double JupiterSeconds = 78.78815;
        double SaturnSeconds = 667.67678;
        double UranusSeconds = 8234.344;
        double NeptuneSeconds = 454.44454;

        System.out.println("Age on Mercury: " + seconds / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + seconds / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + seconds / EarthSeconds);
        System.out.println("Age on Mars: " + seconds / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + seconds / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + seconds / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + seconds / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + seconds / EarthSeconds / NeptuneSeconds);
    }
}
