package utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class LoadConfigFiles {
    private static final Logger LOGGER = LogManager.getLogger(LoadConfigFiles.class);
    public Properties readPropertyValues() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try{
            String propertyFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
            if(inputStream != null){
                properties.load(inputStream);
            }else {
                throw new FileNotFoundException("Properties file " + propertyFileName + " not found");
            }
        }catch (FileNotFoundException e){
            LOGGER.error("Exception is " + e.getMessage());
        }finally {
            //assert inputStream != null;
            inputStream.close();
        }
        return properties;
    }
}
