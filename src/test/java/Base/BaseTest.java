package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

   public  WebDriver driver;

   @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Automation\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");   // are rolul sa mearga la url si sa astepte sa se incarce pagina
        driver.manage().window().maximize();

    }


//    @After
//    public void tearDown(){
//       driver.quit();
//    }


}
