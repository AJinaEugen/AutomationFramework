package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
    private WebDriver driver;
    private ElementMethods elementMethods;

    @FindBy(css = "input[placeholder='E mail']")
    private WebElement emailElement;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordElement;
    @FindBy(id= "enterbtn")
    private WebElement submitElement;
    @FindBy(id = "errormsg")
    private WebElement errormsgElement;

    public SigninPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this); //!!!
        elementMethods= new ElementMethods(driver);
    }

    public SigninPage loginProcess(String email, String password){
        elementMethods.fillElement(emailElement,email);
        elementMethods.fillElement(passwordElement,password);
        elementMethods.clickElement(submitElement);
        return this;
    }


    public SigninPage validateErrorMessage(String expected){
        elementMethods.validateElementMessage(expected,errormsgElement);
        return this;
    }
}
