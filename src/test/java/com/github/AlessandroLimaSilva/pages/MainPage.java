package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Perfil']")
    protected WebElementFacade perfilButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clicarPerfilButtonPage(){
        waitForElement(perfilButton);
        click(perfilButton);
    }
}
