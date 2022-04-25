package com.github.AlessandroLimaSilva.pages;

public class BemVindo extends PageBase{

    @AndroidFindBy(xpath = "//*[contains(@text,'PRÓXIMO PASSO')]//self::android.widget.Button")
    protected WebElement proximoPassoButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'exit outline SAIR')]//self::android.widget.Button")
    protected WebElement sairButton;

    public void clicarEmProximoPasso(){
        waitForElement(proximoPassoButton);
        click(proximoPassoButton);
    }

    public void clicarEmSairButton(){
        waitForElement(sairButton);
        click(sairButton);
    }
}
