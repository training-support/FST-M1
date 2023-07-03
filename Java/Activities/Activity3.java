package Activities;

import java.text.DecimalFormat;

public class Activity3 {
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("0.00");

        double seconds = 1000000000;

        double mercurySeconds = 0.2408467;
        double venusSeconds = 0.61519726;
        double earthSeconds = 31557600;
        double marsSeconds = 1.8808158;
        double jupiterSeconds = 11.862615;
        double saturnSeconds = 29.447498;
        double uranusSeconds = 84.016846;
        double neptuneSeconds = 164.79132;

        System.out.println("Age on Earth is = "+df.format(seconds/earthSeconds));
        System.out.println("Age on Mercury is = "+df.format(seconds/earthSeconds/mercurySeconds));
        System.out.println("Age on Venus is = "+df.format(seconds/earthSeconds/venusSeconds));
        System.out.println("Age on Mars is = "+df.format(seconds/earthSeconds/marsSeconds));
        System.out.println("Age on Jupiter is = "+df.format(seconds/earthSeconds/jupiterSeconds));
        System.out.println("Age on Saturn is = "+df.format(seconds/earthSeconds/saturnSeconds));
        System.out.println("Age on Uranus is = "+df.format(seconds/earthSeconds/uranusSeconds));
        System.out.println("Age on Neptune is = "+df.format(seconds/earthSeconds/neptuneSeconds));
    }
}