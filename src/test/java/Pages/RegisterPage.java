package Pages;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;
    private ElementMethods elementMethods;
    private PageMethods pageMethods;

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstnameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastnameElement;
    @FindBy (css = "input[value='Male']")
    private WebElement maleElement;
    @FindBy(id = "Skills")
    private WebElement skillsDropDownElement;
    @FindBy(id = "yearbox")
    private WebElement yearSelectElement;
    @FindBy(id = "imagesrc")
    private WebElement importElement;
    @FindBy(id = "msdd")
    private WebElement languageSelectElement;
    @FindBy(css = ".ui-widget-content li")
    private List<WebElement> languageElements;
    @FindBy(css = ".select2-selection")
    private WebElement selectCountryElement;
    @FindBy(css = ".select2-search__field")
    private WebElement searchFieldElement;
    @FindBy(xpath = "//a[contains(text(),'Switch')]")
    private WebElement switchtoElement;
    @FindBy(css = "a[href='Frames.html']")
    private WebElement framesubmenuElement;


    public RegisterPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementMethods= new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
    }

    public RegisterPage registerProcess(String firstname,String lastname,String skill
            ,String year,String image,String language1, String language2,String tara){

        elementMethods.fillElement(firstnameElement,firstname);
        elementMethods.fillElement(lastnameElement,lastname);
        elementMethods.clickElement(maleElement);
        elementMethods.selectElementbytxt(skillsDropDownElement,skill);
        elementMethods.selectElementbyvalue(yearSelectElement,year);
        elementMethods.fillElement(importElement,image);
        languageprocess(language1,language2);
        elementMethods.clickElement(selectCountryElement);
        elementMethods.fillElement(searchFieldElement,tara, Keys.RETURN);


        return this;
    }

    public RegisterPage languageprocess(String language1, String language2){
        elementMethods.clickElement(languageSelectElement);
        for (int i = 0; i < languageElements.size(); i++) {
            if (languageElements.get(i).getText().equals(language1) || languageElements.get(i).getText().equals(language2)) {
                languageElements.get(i).click();
            }
        }
        lastnameElement.click();
        return this;
    }

    public FramePage gotoFrameProcess(){
        elementMethods.hoverElement(switchtoElement);
        elementMethods.clickElement(framesubmenuElement);
        pageMethods.navigateToPage("http://demo.automationtesting.in/Frames.html");
        return new FramePage(driver);
    }
}
