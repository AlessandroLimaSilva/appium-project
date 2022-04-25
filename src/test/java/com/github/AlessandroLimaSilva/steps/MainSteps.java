package com.github.AlessandroLimaSilva.steps;

import com.github.AlessandroLimaSilva.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MainSteps extends ScenarioSteps {

    MainPage mainPage;

    @Step("seleciona login")
    public void selecionarLogin(){
        mainPage.carregarApp();
        mainPage.clicarLoginButton();
    }

    @Step("efetua click no botao perfil")
    public void clicarNoBotaoPerfil(){
        mainPage.clicarPerfilButtonPage();
    }
}
