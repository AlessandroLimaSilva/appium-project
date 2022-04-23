package com.github.AlessandroLimaSilva.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    WebDriver driver;

    @Before
    public void beforeTest() {

    }

    @After
    public void afterTest()
    {
        Serenity.getWebdriverManager().resetDriver();
    }
}
