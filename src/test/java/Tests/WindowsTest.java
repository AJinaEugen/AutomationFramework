package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends BaseTest {

     ElementMethods elementmethods;
     PageMethods pagemethods;

    @Test
            public void testwindows() {

          elementmethods = new ElementMethods(driver);
          pagemethods = new PageMethods(driver);

        //Validam pagina de de pornire
        String expectedindexpage = "Index";
        pagemethods.validateTitlepage(expectedindexpage);

        WebElement Skipsigninbutton = driver.findElement(By.id("btn2"));
        elementmethods.clickElement(Skipsigninbutton);

        // Validam pagina de inregistrare
        String expectedindexpageinregistrare = "Register";
        pagemethods.validateTitlepage(expectedindexpageinregistrare);


        WebElement SwitcToelement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        // obiect de tipul actions  !!!!
        Actions hover = new Actions(driver);
        hover.moveToElement(SwitcToelement).build().perform();  // garanteaza


        WebElement WindowsElement = driver.findElement(By.cssSelector("a[href='Windows.html']"));
        WindowsElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> meniuwindwos = driver.findElements(By.cssSelector(".nav-tabs li"));
        meniuwindwos.get(0).click();

        WebElement clickelement = driver.findElement(By.cssSelector(".btn.btn-info"));
        clickelement.click();

        System.out.println(driver.getTitle());
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());  // returneaza o lista cu taburi
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));  //focus


        meniuwindwos.get(2).click();
        WebElement okbuttonelement = driver.findElement(By.cssSelector("button[onclick='multiwindow()']"));
        okbuttonelement.click();
        ArrayList<String> multipletabs = new ArrayList<>(driver.getWindowHandles());
       System.out.print(multipletabs.size());
        driver.switchTo().window(multipletabs.get(2));
        System.out.println("Title 1/2 tabs"+ " "+ driver.getTitle());
        driver.close();


        driver.switchTo().window(multipletabs.get(1));
        System.out.println("Title 2/2 tabs"+ " "+driver.getTitle());
        driver.close();
        driver.switchTo().window(multipletabs.get(0));


        meniuwindwos.get(1).click();
        WebElement windowelement = driver.findElement(By.cssSelector("button[onclick='newwindow()']"));
        windowelement.click();

        ArrayList<String> newwindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newwindow.get(1));
        System.out.println("Title new window:"+ " " +driver.getTitle());
        driver.close();
        driver.switchTo().window(newwindow.get(0));















    }
}
