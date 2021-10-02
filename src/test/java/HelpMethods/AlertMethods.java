package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver){
        this.driver= driver;
    }


    public void AcceptAllertM(){
        waitAlert();
        driver.switchTo().alert().accept();
    }

    public  void DismissAllertM(){
        waitAlert();
        driver.switchTo().alert().dismiss();
    }

    public void AcceptFillAlert(String mesaj){
        waitAlert();
        driver.switchTo().alert().sendKeys(mesaj);
        driver.switchTo().alert().accept();
    }

    public void DismissFillAlert(String mesaj){
        waitAlert();
        driver.switchTo().alert().sendKeys(mesaj);
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(){
        waitAlert();
        return driver.switchTo().alert().getText();
    }

    public void waitAlert(){
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
    }

}
