package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver= driver;
    }

    public void validateTitlepage(String expected ){
        String actual = driver.getTitle();// returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Pagina dorita: "+expected+" ", expected, actual);

    }



}
