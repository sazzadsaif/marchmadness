package utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
public class SqlConnector {
    private static final String userName = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String password = ReadConfigFiles.getPropertyValues("DbPassword");
    private static final String databaseName = ReadConfigFiles.getPropertyValues("DbName");
    //private static final String Url = "jdbc:postgresql://localhost:5432/" + databaseName + "";
    private static final String Url = String.format("jdbc:postgresql://localhost:5432/%s",databaseName);
    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);
    private static Connection sqlConnect() throws SQLException {
        Connection sqlConn = null; // Object of the Connection class
        sqlConn = DriverManager.getConnection(Url,userName,password);
        return sqlConn;
    }
    public static ResultSet readData(String sqlQuery) throws SQLException {
        ResultSet rs = null; //Object of the ResultSet class
        Connection conn = null;
       try {
           conn = sqlConnect();
           rs = conn.createStatement().executeQuery(sqlQuery);
       }catch (SQLException e){
           LOGGER.error(e.getMessage());
       }finally {
           conn.close();
       }
       return rs;
    }
}
