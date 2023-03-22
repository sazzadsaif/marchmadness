package playGround;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import utilities.SqlConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExampleTest.class);
    @Test
    public void run() throws SQLException {
        ResultSet resultSet = SqlConnector.readData("Select * from monthly_mortgage");
        try {
            while(resultSet.next()){
                LOGGER.info(resultSet.getString("homevalue"));
                LOGGER.info(resultSet.getString("downpayment"));
                LOGGER.info(resultSet.getString("loanamount"));
            }
        }catch (SQLException e){
            LOGGER.error(e.getMessage());

        }
    }
}
