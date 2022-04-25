package com.github.AlessandroLimaSilva.pages;

import com.github.AlessandroLimaSilva.bases.PageBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastrarDispositivoPage extends PageBase {

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[1]")
    protected WebElement marcaButton;

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[2]")
    protected WebElement modeloButton;

    @AndroidFindBy(xpath = "(//*[contains(@text,'')]//self::android.widget.Button)[3]")
    protected WebElement sistemaOperacionalButton;

    public CadastrarDispositivoPage(WebDriver driver) {
        super(driver);
    }

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//*[contains(@text,'Acer')]//self::android.widget.Button")
    protected WebElement selecionarMarcaButton;

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Asus']")
    protected WebElement selecionarModeloButton;

    //Xpath dinamico so trocar o nome
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Android 1.5 Cupcake']")
    protected WebElement selecionarSistemaOperacionalButton;

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
        WebElement tipoMarca = driver.findElement(By.xpath(path));
        waitForElement(tipoMarca);
        click(tipoMarca);
    }

    public void selecionarTipoModeloButton(String modelo){
        String path = "//android.widget.Button[@text='"+modelo+"']";
        WebElement tipoModelo = driver.findElement(By.xpath(path));
        waitForElement(tipoModelo);
        click(tipoModelo);
    }

    public void selecionarTipoSistemaOperacionalButton(String sistemaOperacional){
        String path = "//android.widget.Button[@text='"+sistemaOperacional+"']";
        WebElement tipoSistemaOperacional = driver.findElement(By.xpath(path));
        waitForElement(tipoSistemaOperacional);
        click(tipoSistemaOperacional);
    }

    public void clickFinalizarButton(){
        waitForElement(finalizarButton);
        click(finalizarButton);
    }

    public void clickSairButton(){
        waitForElement(sairButton);
        click(sairButton);
    }

}
