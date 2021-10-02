package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {

    //Declaram metode generale la nivel de interactiune cu elemente.


    public WebDriver driver;

    public ElementMethods(WebDriver driver){

        this.driver= driver;
    }

    public void clickElement(WebElement element){
        waitUntillElementVisible(element);
        element.click();
    }

    public void fillElement(WebElement element, String value){
        waitUntillElementVisible(element);
        element.sendKeys(value);
    }

    public void selectElementbytxt(WebElement element, String value) {
        waitUntillElementVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectElementbyvalue(WebElement element, String value) {
        waitUntillElementVisible(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void fillElement(WebElement element, String value, Keys command){
        waitUntillElementVisible(element);
        element.sendKeys(value, command);
    }

    public void hoverElement(WebElement element){
        waitUntillElementVisible(element);
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    public void validateElementMessage(String expectederrormessage, WebElement element) {
        waitUntillElementVisible(element);
        String actualerrormessage  =element.getText();
        Assert.assertEquals("Mesajul de eroare pentru element nu e bun",expectederrormessage,actualerrormessage);
    }

    public  void waitUntillElementVisible(WebElement element){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
    }

    public  void forceWait(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }




}
