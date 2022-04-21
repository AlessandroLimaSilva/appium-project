package com.github.AlessandroLimaSilva.steps;

import com.github.AlessandroLimaSilva.pages.MeuPerfilPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MeuPerfilSteps extends ScenarioSteps {

    MeuPerfilPage meuPerfilPage;

    @Step("retorna o nome do usuario")
    public String retornaNomeUsuario(){
        return meuPerfilPage.retornarNomeDeUsuario();
    }
}
