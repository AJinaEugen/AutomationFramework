package Tests;

import Base.BaseTest;
import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlerteTests extends BaseTest {




    ElementMethods elementmethods;
    AlertMethods alertMethods;
    PageMethods pageMethods;


    @Test
    public void testalerte(){

        elementmethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        pageMethods = new PageMethods(driver);

        WebElement Skipsigninbutton = driver.findElement(By.id("btn2"));
        elementmethods.clickElement(Skipsigninbutton);

        WebElement SwitcToelement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        // obiect de tipul actions  !!!!

        elementmethods.hoverElement(SwitcToelement);  // garanteaza ca merge cu mouse-ul la element

        WebElement AlerElement = driver.findElement(By.cssSelector("a[href='Alerts.html']"));
        AlerElement.click();


        pageMethods.navigateToPage("http://demo.automationtesting.in/Alerts.html"); // merge si nu asteapta pagina sa se incarce.


        List<WebElement> elementalerts = driver.findElements(By.cssSelector(".nav.nav-tabs.nav-stacked li"));

        // Click pe primul element.
        elementalerts.get(0).click();
        WebElement AllerwithOKelement = driver.findElement(By.cssSelector("button[onclick='alertbox()']"));
        AllerwithOKelement.click();

        System.out.println(alertMethods.getAlertText());  // Verificam daca intelij a interactionat cu alerta
        alertMethods.AcceptAllertM();  // INteractionezi cu alerta.

        elementalerts.get(1).click();
        WebElement AllerwithOKcancelelement = driver.findElement(By.cssSelector("button[onclick='confirmbox()']"));
        AllerwithOKcancelelement.click();
        System.out.println(alertMethods.getAlertText());  // Verificam daca intelij a interactionat cu alerta

        alertMethods.DismissAllertM();


        elementalerts.get(2).click();
        WebElement Allerwithtextelement = driver.findElement(By.cssSelector("button[onclick='promptbox()']"));
        Allerwithtextelement.click();
        alertMethods.AcceptFillAlert("Alexandru");


    }


}
