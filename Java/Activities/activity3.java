package activities;

public class activity3 {

    public static void main (String[] args){
        double seconds = 1000000000;
        double EarthS = 31557600 ;
        double MercuryS = 0.2408467;
        double VenusS = 0.61519726;
        double MarsS = 1.8808158 ;
        double JupiterS = 11.862615;
        double SaturnS = 29.447498;
        double UranusS = 84.016846;
        double NeptuneS = 164.79132;

        System.out.println("Age of Mercury: " + seconds / EarthS / MercuryS + "  Seconds");
        System.out.println("Age of Earth: " + seconds / EarthS + "  Seconds");
        System.out.println("Age of Venus: " + seconds / EarthS / VenusS + "  Seconds");
        System.out.println("Age of Mars: " + seconds / EarthS / MarsS+ "  Seconds");
        System.out.println("Age of Jupiter: " + seconds / EarthS / JupiterS + "  Seconds");
        System.out.println("Age of Saturns: " + seconds / EarthS / SaturnS + "  Seconds");
        System.out.println("Age of Uranus: " + seconds / EarthS / UranusS + "  Seconds");
        System.out.println("Age of Neptunes: " + seconds / EarthS / NeptuneS  + "  Seconds");
    }
}