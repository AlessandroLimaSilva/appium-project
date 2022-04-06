package com.github.AlessandroLimaSilva.bases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverBase extends PageObject {

    public static AndroidDriver<AndroidElement> INSTANCE;

    public static void CreateInstance() throws MalformedURLException {

        if (INSTANCE == null){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "7.0");
            capabilities.setCapability("deviceName", "Pixel_3_API_28");
            capabilities.setCapability("udid","emulator-5554");
            capabilities.setCapability("appPackage", "com.spotify.lite");
            capabilities.setCapability("appActivity", "com.spotify.lite.features.launcher.LauncherActivity");
            capabilities.setCapability("autoGrantPermissions","true");
            INSTANCE = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);
        }
    }

    public static void QuitInstance(){
        INSTANCE.quit();
        INSTANCE = null;
    }

}
