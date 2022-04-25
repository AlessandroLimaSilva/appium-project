package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage extends PageBase {

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[1]")
    protected WebElement primeiroNomeTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[2]")
    protected WebElement sobrenomeTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[3]")
    protected WebElement cpfTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[4]")
    protected WebElement nomeUsuarioTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[5]")
    protected WebElement emailTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[6]")
    protected WebElement senhaTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='PRÓXIMA ETAPA']")
    protected WebElement proximaEtapaButton;

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    public void preencherPrimeiroNomeTextField(String text){
        waitForElement(primeiroNomeTextField);
        sendKeys(primeiroNomeTextField, text);
    }

    public void preencherSobrenomeTextField(String text){
        waitForElement(sobrenomeTextField);
        sendKeys(sobrenomeTextField, text);
    }

    public void preencherCPFTextField(String text){
        waitForElement(cpfTextField);
        sendKeys(cpfTextField, text);
    }

    public void preencherNomeDeUsuarioTextField(String text){
        waitForElement(nomeUsuarioTextField);
        sendKeys(nomeUsuarioTextField, text);
    }

    public void preencherEmailTextField(String text){
        waitForElement(emailTextField);
        sendKeys(emailTextField, text);
    }

    public void preencherSenhaTextField(String text){
        waitForElement(senhaTextField);
        sendKeys(senhaTextField, text);
    }

    public void clicarProximaEtapaButton(){
        waitForElement(proximaEtapaButton);
        click(proximaEtapaButton);
    }
}
