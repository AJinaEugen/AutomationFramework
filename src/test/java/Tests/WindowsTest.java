package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import HelpMethods.WindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends BaseTest {

    ElementMethods elementmethods;
    PageMethods pagemethods;
    WindowMethods windowMethods;


    @Test
    public void testwindows() {

        elementmethods = new ElementMethods(driver);
        pagemethods = new PageMethods(driver);
        windowMethods = new WindowMethods(driver);

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
        //        elementmethods.waitUntillElementVisible(SwitcToelement);
        elementmethods.hoverElement(SwitcToelement);  // garanteaza


        WebElement WindowsElement = driver.findElement(By.cssSelector("a[href='Windows.html']"));
        WindowsElement.click();
        pagemethods.navigateToPage("http://demo.automationtesting.in/Windows.html");

        List<WebElement> meniuwindwos = driver.findElements(By.cssSelector(".nav-tabs li"));
        meniuwindwos.get(0).click();

        WebElement clickelement = driver.findElement(By.cssSelector(".btn.btn-info"));
        clickelement.click();

        System.out.println(driver.getTitle());

        windowMethods.switchtowindow(1);

        System.out.println(driver.getTitle());

        windowMethods.closewindow();

        windowMethods.switchtowindow(0);  //focus


        meniuwindwos.get(2).click();
        WebElement okbuttonelement = driver.findElement(By.cssSelector("button[onclick='multiwindow()']"));
        okbuttonelement.click();

        windowMethods.switchtowindow(2);

        System.out.println("Title 1/2 tabs"+ " "+ driver.getTitle());

        windowMethods.closewindow();


        windowMethods.switchtowindow(1);
        System.out.println("Title 2/2 tabs"+ " "+driver.getTitle());
        windowMethods.closewindow();
        windowMethods.switchtowindow(0);


        meniuwindwos.get(1).click();
        WebElement windowelement = driver.findElement(By.cssSelector("button[onclick='newwindow()']"));
        windowelement.click();

        windowMethods.switchtowindow(1);

        System.out.println("Title new window:"+ " " +driver.getTitle());
        driver.close();
        windowMethods.switchtowindow(0);







    }
}
