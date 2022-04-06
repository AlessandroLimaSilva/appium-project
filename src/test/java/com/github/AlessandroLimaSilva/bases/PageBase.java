package com.github.AlessandroLimaSilva.bases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class PageBase extends PageObject{


    public WebDriver driver;
    public WebDriverWait wait;

    public PageBase() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_28");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability("appPackage", "com.spotify.lite");
        capabilities.setCapability("appActivity", "com.spotify.lite.features.launcher.LauncherActivity");
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element)
    {
        waitForElement(element);
        element.click();
    }

    public void sendKeys(MobileElement element, String text)
    {
        waitForElement(element);
        element.sendKeys(text);
    }

    public String getText(MobileElement element)
    {
        waitForElement(element);
        String text = element.getText();
        return text;
    }
}
