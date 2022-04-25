package com.github.AlessandroLimaSilva.pages;

public class CadastroPage extends PageBase{

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[1]")
    protected primeiroNomeTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[2]")
    protected sobrenomeTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[3]")
    protected cpfTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[4]")
    protected nomeDeUsuario;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[5]")
    protected emailTextField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@text=''])[6]")
    protected senhaTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='PRÓXIMA ETAPA']")
    protected proximaEtapaButton;

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
        waitForElement(nomeDeUsuarioTextField);
        sendKeys(nomeDeUsuarioTextField, text);
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
