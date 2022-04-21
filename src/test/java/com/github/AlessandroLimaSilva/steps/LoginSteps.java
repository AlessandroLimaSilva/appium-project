package com.github.AlessandroLimaSilva.steps;

import com.github.AlessandroLimaSilva.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step("Preencher campo email")
    public void preencherCampoEmail(String email) throws InterruptedException {
        loginPage.preencherEmailTextFieldPage(email);
    }

    @Step("Preencher campo senha")
    public void preencherCampoSenha(String senha){
        loginPage.preencherSenhaTextFieldPage(senha);
    }

    @Step("Clicar no botao entrar")
    public void clicarNoBotaoEntrar(){
        loginPage.clicarEntrarButtonPage();
    }


}
