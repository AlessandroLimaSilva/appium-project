package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MeuPerfilPage extends PageBase {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]")
    protected WebElement nomeUsuario;

    public MeuPerfilPage(WebDriver driver) {
        super(driver);
    }

    public String retornarNomeDeUsuario(){
        return getText(nomeUsuario);
    }
}
