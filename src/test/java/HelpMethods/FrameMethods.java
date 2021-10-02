package HelpMethods;

import Tests.FramesTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver= driver;
    }

    public void switchToFrame(String id){

        new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void switchToFrame(WebElement element){

        new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void switchtomainFrame(){

        driver.switchTo().defaultContent();
    }





}
