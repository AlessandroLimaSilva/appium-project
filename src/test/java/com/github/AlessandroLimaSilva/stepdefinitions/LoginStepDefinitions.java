package com.github.AlessandroLimaSilva.stepdefinitions;

import com.github.AlessandroLimaSilva.steps.LoginSteps;
import com.github.AlessandroLimaSilva.steps.MainSteps;
import com.github.AlessandroLimaSilva.steps.MeuPerfilSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;
    @Steps
    MainSteps mainSteps;
    @Steps
    MeuPerfilSteps meuPerfilSteps;

    @Given("^usuario informa seus dados (.*) (.*)$")
    public void usuarioInformaDados(String email, String senha) throws InterruptedException {
        loginSteps.preencherCampoEmail(email);
        loginSteps.preencherCampoSenha(senha);
    }

    @When("^o usuario confirma login$")
    public void confirmarLogin(){
        loginSteps.clicarNoBotaoEntrar();
    }

    @Then("^o sistema efetua o login (.*)$")
    public void validarLoginNoSistema(String nome){
        mainSteps.clicarNoBotaoPerfil();
        Assert.assertEquals(meuPerfilSteps.retornaNomeUsuario().toLowerCase(), nome);
    }

}
