package Pages;

import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage {

    private WebDriver driver;
    private ElementMethods elementMethods;
    private FrameMethods frameMethods;

    @FindBy(css = ".nav.nav-tabs li")
    private List<WebElement> frameOptionsElement;
    @FindBy(css = "input[type='text']")
    private WebElement singleInputFrameElement;
    @FindBy(css = "iframe[src='MultipleFrames.html']")
    private WebElement bigFrameElement;
    @FindBy(css = "iframe[src='SingleFrame.html']")
    private WebElement littleFrameElement;
    @FindBy(css = "input[type='text']")
    private WebElement texBoxinFrameElement;

    public FramePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
    }


    public FramePage dealWithSingleFrame(String value){
        frameOptionsElement.get(0).click();
        frameMethods.switchToFrame("singleframe");
        singleInputFrameElement.sendKeys(value);
        frameMethods.switchtomainFrame(); // te intoarce cu focus-ul la pagina principala;
        return this;
    }

    public FramePage dealWithMultipleFrames(String value){
        frameOptionsElement.get(1).click();
        frameMethods.switchToFrame(bigFrameElement);
        frameMethods.switchToFrame(littleFrameElement);
        texBoxinFrameElement.sendKeys(value);
        frameMethods.switchtomainFrame();
        return this;
    }
}
