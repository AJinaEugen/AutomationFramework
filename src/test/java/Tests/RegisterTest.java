package Tests;

import Base.BaseTest;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import Property.PropertyFile;
import org.junit.Test;

public class RegisterTest extends BaseTest {



    public ElementMethods elementmethods;
    public PageMethods pagemethods;
    public PropertyFile propertyFile;
    public IndexPage indexPage;
    public RegisterPage registerPage;


    @Test
    public void testRegister() {

        elementmethods = new ElementMethods(driver);
        pagemethods = new PageMethods(driver);
        propertyFile = new PropertyFile("InputData");
        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);



        //Validam pagina de de pornire
        String expectedindexpage = propertyFile.getValueByKey("indexpage");
        indexPage.validatePage(expectedindexpage);
        indexPage.clickSkipSignin();

        // Validam pagina de inregistrare
        String expectedindexpageinregistrare = propertyFile.getValueByKey("registerpage");
        pagemethods.validateTitlepage(expectedindexpageinregistrare);

        String firstnamevalue =propertyFile.getValueByKey("firstname");
        String lastnamevalue = "Jina";
        String skillsValue="Tech Support";
        String yearValue="1995";
        String importfile = "P:\\Documente si poze\\documente\\alexandru JIna\\WIN_20210801_08_13_15_Pro.jpg";
        String languagetoselecct = "English";
        String languagetoselect2 = "Spanish";
        String tara ="Australia";

        registerPage.registerProcess(firstnamevalue,lastnamevalue,skillsValue,yearValue,importfile,languagetoselecct,languagetoselect2,tara);
    }
}
