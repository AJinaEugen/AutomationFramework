package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegisterTest extends BaseTest {



    public ElementMethods elementmethods;
    public PageMethods pagemethods;

    @Test
    public void testRegister() {



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

        WebElement Firstnameelement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnamevalue = "Alexandru";
        elementmethods.fillElement(Firstnameelement,firstnamevalue);

        WebElement Lasnameelement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastnamevalue = "Jina";
        elementmethods.fillElement(Lasnameelement,lastnamevalue);

        WebElement Malebuttonelement = driver.findElement(By.cssSelector("input[value='Male']"));
        Malebuttonelement.click();

        // Interactionez cu un dropdown
        WebElement CountrydropdownElement = driver.findElement(By.id("countries"));
        elementmethods.selectElementbytxt(CountrydropdownElement,"Albania");

        WebElement SkillsdropdownElement = driver.findElement(By.id("Skills"));
        elementmethods.selectElementbytxt(SkillsdropdownElement,"Tech Support");

        WebElement YearselectElement = driver.findElement(By.id("yearbox"));
        elementmethods.selectElementbyvalue(YearselectElement,"1995");


        WebElement importElement = driver.findElement(By.id("imagesrc"));
        String importfile = "P:\\Documente si poze\\documente\\alexandru JIna\\WIN_20210801_08_13_15_Pro.jpg";
        importElement.sendKeys(importfile);

        // Languages element

        WebElement languageselement = driver.findElement(By.id("msdd"));
        languageselement.click();
        List<WebElement> languageelements = driver.findElements(By.cssSelector(".ui-widget-content li"));
        String languagetoselecct = "English";
        String languagetoselect2 = "Spanish";
        for (int i = 0; i < languageelements.size(); i++) {

            if (languageelements.get(i).getText().equals(languagetoselecct) || languageelements.get(i).getText().equals(languagetoselect2)) {
                languageelements.get(i).click();

            }


        }
        Lasnameelement.click();

       String tara ="Australia";
        WebElement selectcountryelement = driver.findElement(By.cssSelector(".select2-selection"));
        selectcountryelement.click();

        WebElement searchfieldlement =driver.findElement(By.cssSelector(".select2-search__field"));
        elementmethods.fillElement(searchfieldlement,tara,Keys.RETURN);












    }
}
