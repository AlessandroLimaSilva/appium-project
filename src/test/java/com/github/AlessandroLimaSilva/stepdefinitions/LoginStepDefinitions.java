package com.github.AlessandroLimaSilva.stepdefinitions;

import com.github.AlessandroLimaSilva.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import javax.swing.*;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("^o usuario informe tipo de login")
    public void loginPorEmail()
    {
        loginSteps.clicarLoginPorEmail();
    }

    @And("^insira os dados de login$")
    public void preencherDadosDeLogin()
    {
        loginSteps.preencherEmailField();
        loginSteps.preencherPasswordField();
    }

    @When("^clica em login$")
    public void clicarEmLogIn()
    {
        loginSteps.clicarLogInButton();
    }

}
