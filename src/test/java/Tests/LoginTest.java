package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import Pages.IndexPage;
import Pages.SigninPage;
import Property.PropertyFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

    // public WebDriver driver;   // o variabila globala - public variabila tip WebDriver
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public PropertyFile propertyFile;
    public IndexPage indexPage;
    public SigninPage signinPage;

    @org.junit.Test
    public void Test(){

        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        propertyFile = new PropertyFile("InputData");
        indexPage = new IndexPage(driver);
        signinPage = new SigninPage(driver);

//        //  System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chrome driver\\chromedriver.exe");// "cheia", locul unde e driverul pe calculator
//
//        // deschizi un browser + accesam un URL
//        driver = new ChromeDriver();
//        driver.get("http://demo.automationtesting.in/Index.html");
//        //Facem browserul modul maximize (mare).
//        driver.manage().window().maximize();

        //Validam pagina de index
        String expectedindexpage=propertyFile.getValueByKey("indexpage");
        indexPage.validatePage(expectedindexpage);
        indexPage.clickSignin();

        String expectedindexlogin="SignIn";
        pageMethods.validateTitlepage(expectedindexlogin);

        String emailvalue = System.currentTimeMillis()+"@gss.com";
        String passwordvalue= "parolameasecreta ";
        signinPage.loginProcess(emailvalue,passwordvalue);

        // Validam mesajul de eroare
        String expectederrormessage="Invalid User Name or PassWord";
        signinPage.validateErrorMessage(expectederrormessage);

    }



}
