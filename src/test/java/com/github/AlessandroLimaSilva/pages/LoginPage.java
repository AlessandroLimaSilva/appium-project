package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends PageBase {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
    protected WebElement loginButton;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='']")
    protected WebElement emailTextField;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='••••••••']")
    protected WebElement senhaTextField;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ENTRAR']")
    protected WebElement entrarButton;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Cadastre-se']")
    protected WebElement cadastreSeButton;

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

    public void clicarCadastreSeButton(){
        waitForElement(cadastreSeButton);
        click(cadastreSeButton);
    }

}
