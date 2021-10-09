package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethods;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FramesTest extends BaseTest {

    ElementMethods elementmethods;
    PageMethods pagemethods;
    FrameMethods frameMethods;
    IndexPage indexPage;
    RegisterPage registerPage;
    FramePage framePage;


    @Test
    public void framesTest(){

        elementmethods = new ElementMethods(driver);
        pagemethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
        framePage = new FramePage(driver);

        //Validam pagina de de pornire
        String expectedindexpage = "Index";
        indexPage.validatePage(expectedindexpage);
        indexPage.clickSkipSignin();

        // Validam pagina de inregistrare
        String expectedindexpageinregistrare = "Register";
        pagemethods.validateTitlepage(expectedindexpageinregistrare);

        registerPage.gotoFrameProcess();
        framePage.dealWithSingleFrame("AlexandruJ");
        framePage.dealWithMultipleFrames("AlexandruE");

    }


}




