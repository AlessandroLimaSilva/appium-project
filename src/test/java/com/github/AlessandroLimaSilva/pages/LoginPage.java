package com.github.AlessandroLimaSilva.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NONE OF THE ABOVE']")
    private WebElementFacade noneOfTheAboveButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private WebElementFacade whatsYourEmailEditText;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private WebElementFacade whatsYourPasswordEditText;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    private WebElementFacade logInButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign Up Free']")
    private WebElementFacade signUpFreeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    private WebElementFacade emailButton;

    public LoginPage(){
        super();
    }

    public void clicarNoneOfTheAboveButton()
    {
        noneOfTheAboveButton.click();
    }

    public void preencherWhatsYourEmailTextField(String email)
    {
        whatsYourEmailEditText.sendKeys(email);
    }

    public void preencherWhatsYourPasswordEditText(String password)
    {

        whatsYourPasswordEditText.sendKeys(password);
    }

    public void clickLogInButton()
    {
        logInButton.click();
    }

    public void clickSignUpFreeButton()
    {
        signUpFreeButton.click();
    }

    public void clickEmailButton()
    {
        emailButton.click();
    }
}
