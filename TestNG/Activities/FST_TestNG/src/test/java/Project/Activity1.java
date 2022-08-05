package Project;

import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 extends BaseClass {

    @Test
    public void homepageTest(){

        String pageTitle= driver.getTitle();
        System.out.println(pageTitle);

        //Assertion for pagetitle
        Assert.assertEquals("SuiteCRM", pageTitle);

            }

    //@BeforeMethod


}
