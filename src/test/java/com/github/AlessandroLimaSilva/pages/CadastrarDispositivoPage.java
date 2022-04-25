package com.github.AlessandroLimaSilva.pages;

public class CadastrarDispositivoPage {

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[1]")
    protected WebElement marcaButton;

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[2]")
    protected WebElement modeloButton;

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[3]")
    protected WebElement sistemaOperacionalButton;

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//*[contains(@text,'Acer')]//self::android.widget.Button")
    protected WebElement marcaSelecionadaButton()

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Asus']")
    protected WebElement modeloSelecionadoButton()

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Android 1.5 Cupcake']")
    protected WebElement modeloSelecionadoButton()

    @AndroidFindBy(xpath = "//android.widget.Button[@text='FINALIZAR']")
    protected WebElement finalizarButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='exit outline SAIR']")
    protected WebElement sairButton;

    public void clicarMarcaButton(){
        waitForElement(marcaButton);
        click(marcaButton);
    }

    public void clicarModeloButton(){
        waitForElement(modeloButton);
        click(modeloButton);
    }

    public void clicarSistemaOperacionalButton(){
        waitForElement(sistemaOperacionalButton);
        click(sistemaOperacionalButton);
    }

    public void selecionarTipoMarcaButton(String marca){
        String path = "//android.widget.Button[@text='"+marca+"']";
        protected WebElement tipoMarca = path;
        waitForElement(tipoMarca);
        click(tipoMarca);
    }

    public void selecionarTipoModeloButton(String modelo){
        String path = "//android.widget.Button[@text='"+modelo+"']";
        protected WebElement tipoModelo = path;
        waitForElement(tipoModelo);
        click(tipoModelo);
    }

    public void selecionarTipoSistemaOperacionalButton(String sistemaOperacional){
        String path = "//android.widget.Button[@text='"+sistemaOperacional+"']";
        protected WebElement tipoSistemaOperacional = path;
        waitForElement(tipoSistemaOperacional);
        click(tipoSistemaOperacional);
    }

    public void clickFinalizarButton(){
        waitForElement(finalizarButton);
        click(finalizarButton);
    }

    public void clickSairButton(){
        waitForElement(sairButton);
        click(sairbutton);
    }

}
