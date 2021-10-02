package HelpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

    public class WindowMethods {
    public WebDriver driver;

    public WindowMethods(WebDriver driver){
        this.driver= driver;
    }

    public void switchtowindow(int i){

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());  // returneaza o lista cu taburi
        driver.switchTo().window(tabs.get(i));
    }

    public void closewindow(){
        driver.close();
    }

}
