package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
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

    @org.junit.Test
    public void Test(){

        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        propertyFile = new PropertyFile("InputData");

//        //  System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chrome driver\\chromedriver.exe");// "cheia", locul unde e driverul pe calculator
//
//        // deschizi un browser + accesam un URL
//        driver = new ChromeDriver();
//        driver.get("http://demo.automationtesting.in/Index.html");
//        //Facem browserul modul maximize (mare).
//        driver.manage().window().maximize();

        //Validam pagina de index
        String expectedindexpage=propertyFile.getValueByKey("indexpage");
        String actualindexpage=driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Index page nu a aparut",expectedindexpage,actualindexpage);

        // declar elementul "Sign in"

        WebElement SigninElement= driver.findElement(By.id("btn1"));
        SigninElement.click();


        String expectedindexlogin="SignIn";
        pageMethods.validateTitlepage(expectedindexlogin);


        WebElement EmailElement = driver. findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailvalue = System.currentTimeMillis()+"@gss.com";
        EmailElement.sendKeys(emailvalue);

        WebElement passwordElement = driver. findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordvalue= "parolameasecreta ";
        passwordElement.sendKeys(passwordvalue);

        WebElement submitElement= driver.findElement(By.id("enterbtn"));
        submitElement.click();

        // Validam mesajul de eroare

        WebElement errormessage=driver.findElement(By.id("errormsg"));
        String expectederrormessage="Invalid User Name or PassWord";


        elementMethods.validateElementMessage(expectederrormessage,errormessage);


    }



}
