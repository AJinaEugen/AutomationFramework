package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver= driver;
    }

    public void validateTitlepage(String expected ){
        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs(expected));
        String actual = driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Pagina dorita: "+expected+" ", expected, actual);
    }

    public void navigateToPage(String url){
        driver.navigate().to(url);
    }



}
