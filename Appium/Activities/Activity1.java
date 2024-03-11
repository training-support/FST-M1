package com.ibm.AppiumPractice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	 @Test
	    public void calc() throws InterruptedException, IOException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 2 API 30");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("appPackage", "com.google.android.calculator");
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	        
	        AppiumDriver<MobileElement> driver = null;
	        try {
	            
	            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	            System.out.println("Calculator is open");
	        } catch (MalformedURLException e) {
	            System.out.println(e.getMessage());
	        }

	        
		 }

}
