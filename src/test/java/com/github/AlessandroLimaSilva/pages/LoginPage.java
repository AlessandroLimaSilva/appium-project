package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LoginPage extends PageBase {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NONE OF THE ABOVE']")
    private MobileElement noneOfTheAboveButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private MobileElement whatsYourEmailEditText;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private MobileElement whatsYourPasswordEditText;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    private MobileElement logInButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign Up Free']")
    private MobileElement signUpFreeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    private MobileElement emailButton;

    public LoginPage() throws MalformedURLException {
    }

    public void clicarNoneOfTheAboveButton()
    {
        click(noneOfTheAboveButton);
    }

    public void preencherWhatsYourEmailTextField(String email)
    {
        sendKeys(whatsYourEmailEditText,email);
    }

    public void preencherWhatsYourPasswordEditText(String password)
    {
        sendKeys(whatsYourPasswordEditText,password);
    }

    public void clickLogInButton()
    {
        click(logInButton);
    }

    public void clickSignUpFreeButton()
    {
        click(signUpFreeButton);
    }

    public void clickEmailButton()
    {
        click(emailButton);
    }
}
