package com.github.AlessandroLimaSilva.stepdefinitions;

import com.github.AlessandroLimaSilva.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import javax.swing.*;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Given("^que o usuario informe")
    public void que_o_usuario_informe_login_por_email()
    {
        loginSteps.clicarLoginPorEmail();
    }

    @And("^insira os dados de login$")
    public void preencherDadosDeLogin()
    {
        loginSteps.preencherEmailField();
        loginSteps.preencherPasswordField();
    }

    @When("^clica em log in$")
    public void clicarEmLogIn()
    {
        loginSteps.clicarLogInButton();
    }

    @Then("^vai se foder serenity$")
    public void vaiSeFoderSerenity() {
        JOptionPane.showMessageDialog(null,"Serenity Filho da puta");
        loginSteps.clicarLogInButton();
    }
}
