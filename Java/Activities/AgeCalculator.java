package Activities;

public class AgeCalculator {

        public static void main(String[] args) {
            long ageInSeconds = 1000000000;


            double earthOrbitalPeriod = 1.0;
            double mercuryOrbitalPeriod = 0.2408467;
            double venusOrbitalPeriod = 0.61519726;
            double marsOrbitalPeriod = 1.8808158;
            double jupiterOrbitalPeriod = 11.862615;
            double saturnOrbitalPeriod = 29.447498;
            double uranusOrbitalPeriod = 84.016846;
            double neptuneOrbitalPeriod = 164.79132;


            double ageInEarthYears = ageInSeconds / (365.25 * 24 * 60 * 60);


            double ageOnMercury = ageInEarthYears / mercuryOrbitalPeriod;
            double ageOnVenus = ageInEarthYears / venusOrbitalPeriod;
            double ageOnMars = ageInEarthYears / marsOrbitalPeriod;
            double ageOnJupiter = ageInEarthYears / jupiterOrbitalPeriod;
            double ageOnSaturn = ageInEarthYears / saturnOrbitalPeriod;
            double ageOnUranus = ageInEarthYears / uranusOrbitalPeriod;
            double ageOnNeptune = ageInEarthYears / neptuneOrbitalPeriod;


            System.out.println("Age in Earth years: " + ageInEarthYears);
            System.out.println("Age on Mercury: " + ageOnMercury);
            System.out.println("Age on Venus: " + ageOnVenus);
            System.out.println("Age on Mars: " + ageOnMars);
            System.out.println("Age on Jupiter: " + ageOnJupiter);
            System.out.println("Age on Saturn: " + ageOnSaturn);
            System.out.println("Age on Uranus: " + ageOnUranus);
            System.out.println("Age on Neptune: " + ageOnNeptune);
        }
}
