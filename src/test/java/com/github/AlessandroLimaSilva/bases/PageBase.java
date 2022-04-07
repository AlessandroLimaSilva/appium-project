package com.github.AlessandroLimaSilva.bases;


import com.google.common.base.Predicate;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class PageBase extends PageObject{


    public WebDriver driver;
    public WebDriverWait wait;

    public PageBase() {

    }

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element)
    {
        waitForElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text)
    {
        waitForElement(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element)
    {
        waitForElement(element);
        String text = element.getText();
        return text;
    }
}
