package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    PageBase pageBase;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NONE OF THE ABOVE']")
    public WebElementFacade noneOfTheAboveButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    public WebElementFacade whatsYourEmailEditText;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    public WebElementFacade whatsYourPasswordEditText;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    public WebElementFacade logInButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign Up Free']")
    public WebElementFacade signUpFreeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    public WebElementFacade emailButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void clicarNoneOfTheAboveButton()
    {
        pageBase.click(noneOfTheAboveButton);
    }

    public void preencherWhatsYourEmailTextField(String email)
    {
        pageBase.sendKeys(whatsYourEmailEditText,email);
    }

    public void preencherWhatsYourPasswordEditText(String password)
    {
        pageBase.sendKeys(whatsYourPasswordEditText,password);
    }

    public void clickLogInButton()
    {
        pageBase.click(logInButton);
    }

    public void clickSignUpFreeButton()
    {
        pageBase.click(signUpFreeButton);
    }

    public void clickEmailButton()
    {
        pageBase.click(emailButton);
    }
}
