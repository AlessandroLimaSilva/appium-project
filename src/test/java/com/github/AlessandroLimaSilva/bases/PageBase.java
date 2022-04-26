package com.github.AlessandroLimaSilva.bases;


import com.google.common.collect.ImmutableMap;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PageBase extends PageObject{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected long timeOutDefault;
    protected long implicitTimeOutDefault;
    protected JavascriptExecutor javascriptExecutor;


    public PageBase(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.timeOutDefault = getWaitForTimeout().toMillis();
        this.implicitTimeOutDefault = getImplicitWaitTimeout().toMillis();
        this.wait = new WebDriverWait(driver, Duration.ofMillis(timeOutDefault));
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }


    // Custom Actions
    public void waitUntilPageReady() {
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= this.timeOutDefault) {
            if (javascriptExecutor.executeScript("return document.readyState").toString().equals("complete")) {
                timeOut.stop();
                break;
            }
        }
    }

    //region Sincronização
    protected void waitLoadingScreen(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                if (element.getAttribute("hidden") == "true")
                {
                    timeOut.stop();
                    return;
                }

            } while (timeOut.getTime() <= timeOutDefault);
        }
        catch (WebDriverException e)
        {

        }
    }

    public void waitAPPLoad(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected  boolean waitForTextPresentElement(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected WebElement waitForElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    //endregion

    //region Mobile Element Methods
    protected void waitForElementToBeClickeable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementByTime(WebElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(time));
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= timeOutDefault)
        {
            //WebElement element = null;
            try
            {
                waitForElement(element);
                element.click();
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e) {
                continue;
            }
            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void sendKeys(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(text);

    }

    //Investigar o que isso faz
    protected  void sendKeysUsingActions(WebElement element, String text)
    {
        waitForElement(element);
        click(element);
        Actions a = new Actions(driver);
        a.sendKeys(text);
        a.perform();
    }

    protected void sendKeysWithoutWaitVisible(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void clear(WebElement element){
        waitForElement(element);
        element.clear();
    }

    protected void clearAndSendKeys(WebElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearAndSendKeysAlternative(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);

    }

    protected String getText(WebElement element){
        waitForElement(element);
        return element.getText();
    }

    protected String getValue(WebElement element){
        waitForElement(element);
        return element.getAttribute("value");
    }

    protected boolean returnIfElementIsDisplayed(WebElement element){
        waitForElement(element);
        return element.isDisplayed();
    }

    protected boolean returnIfElementIsEnabled(WebElement element){
        waitForElement(element);
        return element.isEnabled();
    }

    protected boolean returnIfElementIsSelected(WebElement element){
        waitForElement(element);
        return element.isSelected();
    }


    //Refatorado
    protected void scrollUsingTouchActions_ByElements(WebElement startElement, WebElement endElement) {
        waitForElement(startElement);
        waitForElement(endElement);
        javascriptExecutor.executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)startElement).getId()),
                "elementId",((RemoteWebElement) endElement ).getId());
    }

    protected void scrollTimeUsingTouchActions_ByElements(WebElement startElement, WebElement endElement, int seconds) {
        waitForElement(startElement);
        waitForElement(endElement);
        javascriptExecutor.executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)startElement).getId()),
                "elementId",((RemoteWebElement) endElement ).getId(), seconds);
    }

    protected void scrollUsingTouchActions(int startX, int startY, int endX, int endY) {
        javascriptExecutor.executeScript("mobile: dragGesture",
                ImmutableMap.of(startX , startY, endX, endY));
    }

    //Refatorado
    //Refatorar Metodos novos padroes de implementações de touch e actions
    protected void longPress(WebElement element) {
        waitForElement(element);
        javascriptExecutor.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
    }


    //Novo metodo adicionado
    protected void longPressWaitPressTime(WebElement element, int time) {
        waitForElement(element);
        javascriptExecutor.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId()), time);
    }

    //Refatorado
    protected void tap(WebElement element){
        waitForElement(element);
        javascriptExecutor.executeScript("mobile: clickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement) element ).getId()));
    }

    //Novo metodo adicionado
    protected void tapCoordinates(String x, String y){
        javascriptExecutor.executeScript("mobile: clickGesture", ImmutableMap.of(x , y));
    }

    //Refatorado
    protected void doubleTap(WebElement element){
        waitForElement(element);
        javascriptExecutor.executeScript("mobile: doubleClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement) element ).getId()));

    }

    //Novo metodo adicionado
    protected void doubleTapCoordinates(int x, int y){
        javascriptExecutor.executeScript("mobile: doubleClickGesture", ImmutableMap.of(x , y));
    }

    //Refatorar Metodos novos padroes de implementações de touch e actions
    //endregion Mobile Element Methods

    //region List Mobile Elements Methods
    protected String[] returnTextListMobileElements(List<WebElement> elementList){
        int i = 0;
        String[] allText = new String[elementList.size()];

        for (WebElement element : elementList) {
            allText[i++] = element.getText();
        }
        return allText;
    }

    protected int returnCountMobileElements(List<WebElement> elementList){
        return elementList.size();
    }

    protected void clickFirstElementList(List<WebElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (WebElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                click(element);
                break;
            }
        }
    }

    protected void clickElementInList(List<WebElement> listElement, int position){
        waitForElement(listElement.get(position));
        click(listElement.get(position));
    }

    protected String clickRandomElementList(List<WebElement> listElement){
        String textElement = "";

        waitForElement(listElement.get(0));
        Random rand = new Random();
        int position = rand.nextInt(listElement.size());
        WebElement elementRandom = listElement.get(position);
        textElement = getText(elementRandom);
        click(elementRandom);

        return textElement;
    }

    protected String clickElementList(List<WebElement> listElement, String textElement){
        waitForElement(listElement.get(0));

        for (WebElement element : listElement) {
            if(element.getText().equals(textElement)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String returnTextFirstElementList(List<WebElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (WebElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                break;
            }
        }
        return textElement;
    }

    //endregion List Mobile Elements Methods

    //region By Locator Methods
    protected int returnCountMobileElements(By locator){
        waitForElement(locator);
        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        return mobileElementList.size();
    }

    protected String[] returnTextListMobileElements(By locator){
        int i = 0;
        waitForElement(locator);
        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        String[] allText = new String[mobileElementList.size()];

        for (WebElement element : mobileElementList) {
            allText[i++] = element.getText();
        }

        return allText;
    }

    protected String clickFirstElementList(By locator){
        waitForElement(locator);
        WebElement mobileElement = (WebElement) driver.findElements(locator).get(0);
        click(mobileElement);
        return mobileElement.getText();
    }

    protected String clickFirstElementList(By locator, String textNotContains){
        waitForElement(locator);
        String textElement = "";

        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        for (WebElement element : mobileElementList) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        return text;
    }

    //endregion By Locator Methods

    //region General Methods
    protected void scrolling(String direction){
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        javascriptExecutor.executeScript("mobile: scroll", scrollObject);
    }


    //Refatorar metodo nova implementação de scroll
    protected  void scrollingEntire(){
        javascriptExecutor. executeScript ( "mobile: scrollGesture" ,
                ImmutableMap.of (
                "direction" , "down" ,
                "percent" , 1.0
        ) );
    }

    //
    public void topToBottonSwipe() {
        Dimension dim= driver.manage().window().getSize();
        int height = dim.getHeight();
        int width =  dim.getWidth();
        int x= width/2;
        int startY=(int) (height*0.80);
        int endY=(int) (height*0.20);

        javascriptExecutor.executeScript("mobile: dragGesture",
                ImmutableMap.of(x , startY, x, endY));
    }

    //Função para realizar scroll somente em Android
    /*
    protected WebElement scrollToElementAndroid(String string){
        return ((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+string+"\").instance(0))");
    }*/
    //endregion General Methods

}
