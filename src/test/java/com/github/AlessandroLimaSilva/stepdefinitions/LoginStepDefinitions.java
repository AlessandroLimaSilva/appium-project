package com.github.AlessandroLimaSilva.stepdefinitions;

import com.github.AlessandroLimaSilva.enums.Usuario;
import com.github.AlessandroLimaSilva.steps.LoginSteps;
import com.github.AlessandroLimaSilva.steps.MainSteps;
import com.github.AlessandroLimaSilva.steps.MeuPerfilSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
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

    @Given("^possui dados (.*) (.*) (.*)$")
    public void usuarioPossuiOsDadosEmailSenhaNome(String email, String senha, String nome) {
        Serenity.setSessionVariable(Usuario.EMAIL).to(email);
        Serenity.setSessionVariable(Usuario.SENHA).to(senha);
        Serenity.setSessionVariable(Usuario.NOME).to(nome);
    }

    @And("^informa dados$")
    public void UsuarioInformaOsDados() throws InterruptedException {
        loginSteps.preencherCampoEmail((String) Serenity.sessionVariableCalled(Usuario.EMAIL).toString());
        loginSteps.preencherCampoSenha((String) Serenity.sessionVariableCalled(Usuario.SENHA));
    }

    @Then("o sistema efetua o login")
    public void SistemaEfetuaOLogin() {
        mainSteps.clicarNoBotaoPerfil();
        Assert.assertEquals(meuPerfilSteps.retornaNomeUsuario().toLowerCase(), (String) Serenity.sessionVariableCalled(Usuario.NOME));
    }
}
