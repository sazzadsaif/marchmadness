package testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExampleTest.class);
    @Test
    public void run(){
        LOGGER.info(ReadConfigFiles.getPropertyValues("DbUser"));
        LOGGER.info(ReadConfigFiles.getPropertyValues("DbPassword"));
        LOGGER.info(ReadConfigFiles.getPropertyValues("DbName"));
    }
}
