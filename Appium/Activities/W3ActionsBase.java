package activities;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;

import javax.sound.midi.Sequence;

import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class W3ActionsBase {
    private static final PointerInput pointer=new PointerInput(PointerInput.Kind.TOUCH,"finger");
    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration){

      //  Sequence swipe=new Sequence(pointer,1)
         //       .addAction(pointer.CreatePointerMove(ofMillis(0),viewport(),start.getX(),start.getY()))
           //     .addAction(pointer.CreatePointerDown(LEFT.asArg()))
             //   .addAction(pointer.CreatePointerMove(ofMillis(duration),viewport(),end.getX(),end.getY()))
               // .addAction(pointer.CreatePointerUp(LEFT.asArg()));
      //  driver.perform(Arrays.asList(swipe));

    }

}
