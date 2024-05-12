package Activities;

import java.util.Scanner;

public class Acitivity3 {
    public static void main(String[] args) {
        // User input for age in years
        int ageInYears = getUserAge();

        // Convert age to seconds
        long ageInSeconds = ageInYears * 365 * 24 * 60 * 60;

        // Orbital periods of planets in Earth years
        double earthOrbitalPeriod = 1.0;
        double mercuryOrbitalPeriod = 0.2408467;
        double venusOrbitalPeriod = 0.61519726;
        double marsOrbitalPeriod = 1.8808158;
        double jupiterOrbitalPeriod = 11.862615;
        double saturnOrbitalPeriod = 29.447498;
        double uranusOrbitalPeriod = 84.016846;
        double neptuneOrbitalPeriod = 164.79132;

        // Calculate age on other planets
        double ageOnMercury = ageInSeconds / (365.25 * 24 * 60 * 60) * mercuryOrbitalPeriod;
        double ageOnVenus = ageInSeconds / (365.25 * 24 * 60 * 60) * venusOrbitalPeriod;
        double ageOnMars = ageInSeconds / (365.25 * 24 * 60 * 60) * marsOrbitalPeriod;
        double ageOnJupiter = ageInSeconds / (365.25 * 24 * 60 * 60) * jupiterOrbitalPeriod;
        double ageOnSaturn = ageInSeconds / (365.25 * 24 * 60 * 60) * saturnOrbitalPeriod;
        double ageOnUranus = ageInSeconds / (365.25 * 24 * 60 * 60) * uranusOrbitalPeriod;
        double ageOnNeptune = ageInSeconds / (365.25 * 24 * 60 * 60) * neptuneOrbitalPeriod;

        // Print results
        System.out.println("Age on Mercury: " + ageOnMercury + " Earth years");
        System.out.println("Age on Venus: " + ageOnVenus + " Earth years");
        System.out.println("Age on Mars: " + ageOnMars + " Earth years");
        System.out.println("Age on Jupiter: " + ageOnJupiter + " Earth years");
        System.out.println("Age on Saturn: " + ageOnSaturn + " Earth years");
        System.out.println("Age on Uranus: " + ageOnUranus + " Earth years");
        System.out.println("Age on Neptune: " + ageOnNeptune + " Earth years");
    }

    public static int getUserAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age in years: ");
        int age = scanner.nextInt();
        return age;
    }
}
