package Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    public FileInputStream file;

    public Properties property;

    public PropertyFile (String numefisier){
        loadFile(numefisier);
    }


    // Incarcam fisierul specific

    public void loadFile(String numefisier){

        property = new Properties();
        try {
            file = new FileInputStream("src/test/resources/InputData/"+numefisier+".properties");
            property.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Returnam o valoare pe baza unei chei

    public String getValueByKey(String key){

        return property.getProperty(key);
    }
}
