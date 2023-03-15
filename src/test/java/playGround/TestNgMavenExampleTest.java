package playGround;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.DateUtils;
import utilities.ReadConfigFiles;

import java.net.URL;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExampleTest.class);
    @Test
    public void run(){
        String browserUrl = ReadConfigFiles.getPropertyValues("URL");
        System.out.println(browserUrl);
    }
}
