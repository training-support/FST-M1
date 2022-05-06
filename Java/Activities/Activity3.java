
public class Activity3 {
	public static void main(String[] args) {
		double seconds = 1000000000;
		double earthSeconds = 31557600;
		double mercurySeconds = 0.2408467;
		double venusSeconds = 0.61519726;
		double marsSeconds = 1.8808158;
		double jupiterSeconds = 11.862615;
		double saturnSeconds = 29.447498;
		double uranusSeconds = 84.016846;
		double neptuneSeconds = 164.79132;

		double earthYear = seconds / earthSeconds;
		System.out.println("Age on Mercury: " + earthYear / mercurySeconds);
		System.out.println("Age on Venus: " + earthYear / venusSeconds);
		System.out.println("Age on Earth: " + earthYear);
		System.out.println("Age on Mars: " + earthYear / marsSeconds);
		System.out.println("Age on Jupiter: " + earthYear / jupiterSeconds);
		System.out.println("Age on Saturn: " + earthYear / saturnSeconds);
		System.out.println("Age on Uranus: " + earthYear / uranusSeconds);
		System.out.println("Age on Neptune: " + earthYear / neptuneSeconds);
	}
}
