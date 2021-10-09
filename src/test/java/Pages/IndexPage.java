package Pages;

import HelpMethods.ElementMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private WebDriver driver;
    private ElementMethods elementMethods;

    // 1.Declaram elementele

    @FindBy(id = "btn2")
    private WebElement skipsigninElement;
    @FindBy(id = "btn1")
    private WebElement signinElement;

    //2.Declaram Constructorul

    public IndexPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementMethods= new ElementMethods(driver);
    }

    //3.Declaram metodele pentru elementele din clasa

    public RegisterPage clickSkipSignin(){
        elementMethods.clickElement(skipsigninElement);
        return new RegisterPage(driver);
    }

    public SigninPage clickSignin(){
        elementMethods.clickElement(signinElement);
        return  new SigninPage(driver);
    }

    public IndexPage validatePage(String expected){
        String actualindexpage=driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Index page nu a aparut",expected,actualindexpage);

        return this;
    }



}
