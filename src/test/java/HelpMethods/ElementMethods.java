package HelpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementMethods {

    //Declaram metode generale la nivel de interactiune cu elemente.


    public WebDriver driver;

    public ElementMethods(WebDriver driver){

        this.driver= driver;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void selectElementbytxt(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectElementbyvalue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void fillElement(WebElement element, String value, Keys command){
        element.sendKeys(value, command);
    }

}
