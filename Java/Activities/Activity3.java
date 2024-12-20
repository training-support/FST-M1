package activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double seconds = 1000000000;

		double earthSeconds = 31557600;
		double mercurySeconds = 0.2408467;
		double venusSeconds = 0.61519726;
		double marsSeconds = 1.8808158;
		double jupiterSeconds = 11.862615;
		double saturnSeconds = 29.447498;
		double uranusSeconds = 84.016846;
		double neptuneSeconds = 164.79132;

		System.out.println("AGE ON MERCURY is     :" + seconds / earthSeconds / mercurySeconds);
		System.out.println("AGE ON VENUS is     :" + seconds / earthSeconds / venusSeconds);

		System.out.println("AGE ON EARTH is     :" + seconds / earthSeconds);

		System.out.println("AGE ON MARS is     :" + seconds / earthSeconds / marsSeconds);

		System.out.println("AGE ON JUPITER is     :" + seconds / earthSeconds / jupiterSeconds);

		System.out.println("AGE ON SATURN is     :" + seconds / earthSeconds / saturnSeconds);
		System.out.println("AGE ON URANUS is     :" + seconds / earthSeconds / uranusSeconds);

		System.out.println("AGE ON NEPTUNE is     :" + seconds / earthSeconds / neptuneSeconds);

	}

}
