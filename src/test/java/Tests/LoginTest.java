package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public WebDriver driver;   // o variabila globala - public variabila tip WebDriver


    @org.junit.Test
    public void Test(){


        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chrome driver\\chromedriver.exe");// "cheia", locul unde e driverul pe calculator

        // deschizi un browser + accesam un URL
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        //Facem browserul modul maximize (mare).
        driver.manage().window().maximize();

        //Validam pagina de index
        String expectedindexpage="Index";
        String actualindexpage=driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Index page nu a aparut",expectedindexpage,actualindexpage);

        // declar elementul "Sign in"

        WebElement SigninElement= driver.findElement(By.id("btn1"));
        SigninElement.click();


        String expectedindexlogin="SignIn";
        String actualindexlogin= driver.getTitle();
        Assert.assertEquals("Pagina nu a fost gasita",expectedindexlogin,actualindexlogin);


        WebElement EmailElement = driver. findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailvalue = "alexandru.alexandruy@gss.com";
        EmailElement.sendKeys(emailvalue);

        WebElement passwordElement = driver. findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordvalue= "parolameasecreta ";
        passwordElement.sendKeys(passwordvalue);

        WebElement submitElement= driver.findElement(By.id("enterbtn"));
        submitElement.click();

        // Validam mesajul de eroare

        WebElement errormessage=driver.findElement(By.id("errormsg"));
        String expectederrormessage="Invalid User Name or PassWord";
        String actualerrormessage  = errormessage.getText();

        Assert.assertEquals("Mesajul de eroare pentru login nu e bun",expectederrormessage,actualerrormessage);





    }



}
