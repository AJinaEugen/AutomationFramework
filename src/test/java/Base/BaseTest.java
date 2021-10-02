package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

   public  WebDriver driver;

   @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");   // are rolul sa mearga la url si sa astepte sa se incarce pagina
        driver.manage().window().maximize();

        // Declaram un wait implicit

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


//    @After
//    public void tearDown(){
//       driver.quit();
//    }


}
