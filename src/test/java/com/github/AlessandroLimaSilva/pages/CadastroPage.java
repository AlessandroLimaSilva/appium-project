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
}
