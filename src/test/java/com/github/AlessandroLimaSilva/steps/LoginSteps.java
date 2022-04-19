package com.github.AlessandroLimaSilva.steps;

import com.github.AlessandroLimaSilva.pages.LoginPageBase;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {
    LoginPageBase loginPage;

    @Step("Clicar no botão login por email")
    public void clicarLoginPorEmail()
    {
        loginPage.clickEmailButton();
    }

    @Step("Preencher campo email")
    public void preencherEmailField()
    {
        String email = "base2appium@gmail.com";
        loginPage.preencherWhatsYourEmailTextField(email);
    }

    @Step("Preencher campo password")
    public void preencherPasswordField()
    {
        String password = "base2102030";
        loginPage.preencherWhatsYourPasswordEditText(password);
    }

    @Step("Clicar no botão Log in")
    public void clicarLogInButton()
    {
        loginPage.clickLogInButton();
    }

    @Step("Clicar no botão none of the above")
    public void clicarNoneOfTheAboveButton()
    {
        loginPage.clicarNoneOfTheAboveButton();
    }

    @Step("Clicar no botão sign up free")
    public void clicarSignUpFreeButton()
    {
        loginPage.clickSignUpFreeButton();
    }

    @Step("Clicar no botão login por email")
    public void clicarEmailButton()
    {
        loginPage.clickEmailButton();
    }
}
