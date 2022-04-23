package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends PageBase {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText[1]")
    protected WebElement emailTextField;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText[2]")
    protected WebElement senhaTextField;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='ENTRAR']")
    protected WebElement entrarButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void preencherEmailTextFieldPage(String email) throws InterruptedException {

        waitForElement(emailTextField);
        sendKeys(emailTextField,email);
    }

    public void preencherSenhaTextFieldPage(String senha){
        sendKeys(senhaTextField,senha);
    }

    public void clicarEntrarButtonPage(){
        waitForElement(entrarButton);
        click(entrarButton);
    }

}
