package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {

    public WebDriver driver;

    @Test
    public void testRegister(){

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Chrome driver\\chromedriver.exe");// "cheia", locul unde e driverul pe calculator
         driver = new ChromeDriver();
         driver.get("http://demo.automationtesting.in/Index.html");
         driver.manage().window().maximize();



        //Validam pagina de de pornire
        String expectedindexpage="Index";
        String actualindexpage=driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Index page nu a aparut",expectedindexpage,actualindexpage);

        WebElement Skipsigninbutton = driver.findElement(By.id("btn2"));
        Skipsigninbutton.click();


        // Validam pagina de inregistrare
        String expectedindexpageinregistrare="Register";
        String actualindexpageinregistrare =driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("pagina de inregistrare nu e corecta ",expectedindexpageinregistrare,actualindexpageinregistrare);


        WebElement Firstnameelement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnamevalue="Alexandru";
        Firstnameelement.sendKeys(firstnamevalue);
        WebElement Lasnameelement  = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastnamevalue="Jina";
        Lasnameelement.sendKeys(lastnamevalue);

        WebElement Malebuttonelement = driver.findElement(By.cssSelector("input[value='Male']"));
        Malebuttonelement.click();

        // Interactionez cu un dropdown
        WebElement CountrydropdownElement = driver.findElement(By.id("countries"));
        Select countryselect = new Select(CountrydropdownElement);
        countryselect.selectByVisibleText("Albania");

        WebElement SkillsdropdownElement = driver.findElement(By.id("Skills"));
        Select skillsselect = new Select(SkillsdropdownElement);
        skillsselect.selectByVisibleText("Tech Support");


        WebElement YearselectElement = driver.findElement(By.id("yearbox"));
        Select Yearselect = new Select(YearselectElement);
        Yearselect.selectByValue("1995");


        WebElement importElement = driver.findElement(By.id("imagesrc"));
        String importfile = "P:\\Documente si poze\\documente\\alexandru JIna\\WIN_20210801_08_13_15_Pro.jpg";
        importElement.sendKeys(importfile);



    }


}
