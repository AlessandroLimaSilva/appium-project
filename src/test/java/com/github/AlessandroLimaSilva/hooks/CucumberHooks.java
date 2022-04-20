package com.github.AlessandroLimaSilva.hooks;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    WebDriver driver;

    @Before
    public void beforeTest() {

    }

    @After
    public void afterTest()
    {
    }
}
