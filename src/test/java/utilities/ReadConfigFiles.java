package utilities;

import com.beust.jcommander.internal.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ReadConfigFiles {
    private static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static  String getPropertyValues(String propertyName){
        Properties prop;
        String propertyValue = null;
        try{
            prop = new LoadConfigFiles().readPropertyValues();
            propertyValue = prop.getProperty(propertyName);
        }catch (Exception e){
            LOGGER.error(e.getMessage());

        }
        return propertyValue;
    }
}
