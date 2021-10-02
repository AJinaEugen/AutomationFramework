package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FramesTest extends BaseTest {

    ElementMethods elementmethods;
    PageMethods pagemethods;
    FrameMethods frameMethods;

    @Test
    public void framesTest(){

        elementmethods = new ElementMethods(driver);
        pagemethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);

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

        elementmethods.hoverElement(SwitcToelement);  // garanteaza ca merge cu mouse-ul la element

        WebElement AlerElement = driver.findElement(By.cssSelector("a[href='Frames.html']"));
        AlerElement.click();

        pagemethods.navigateToPage("http://demo.automationtesting.in/Frames.html");

        List<WebElement> frameelement = driver.findElements(By.cssSelector(".nav.nav-tabs li"));

        frameelement.get(0).click();


        frameMethods.switchToFrame("singleframe");

        WebElement textboxelement = driver.findElement(By.cssSelector("input[type='text']"));
        textboxelement.sendKeys("AlexandruJ");

        frameMethods.switchtomainFrame(); // te intoarce cu focus-ul la pagina principala;


        frameelement.get(1).click();

        WebElement BigIframe = driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']"));
        frameMethods.switchToFrame(BigIframe);

        WebElement Littleframe =driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
        frameMethods.switchToFrame(Littleframe);

        WebElement textboxinframe = driver.findElement(By.cssSelector("input[type='text']"));
        textboxinframe.sendKeys("AlexandruJ");

        frameMethods.switchtomainFrame();

        frameelement.get(0).click();




    }




}




