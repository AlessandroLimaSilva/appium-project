package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageBase {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Perfil']")
    protected WebElement perfilButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clicarPerfilButtonPage(){
        waitForElement(perfilButton);
        click(perfilButton);
    }
}
