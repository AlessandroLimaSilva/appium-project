package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BemVindoPage extends PageBase {

    @AndroidFindBy(xpath = "//*[contains(@text,'PRÓXIMO PASSO')]//self::android.widget.Button")
    protected WebElement proximoPassoButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'exit outline SAIR')]//self::android.widget.Button")
    protected WebElement sairButton;

    public BemVindoPage(WebDriver driver) {
        super(driver);
    }

    public void clicarEmProximoPasso(){
        waitForElement(proximoPassoButton);
        click(proximoPassoButton);
    }

    public void clicarEmSairButton(){
        waitForElement(sairButton);
        click(sairButton);
    }
}
