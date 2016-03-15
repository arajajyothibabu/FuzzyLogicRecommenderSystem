package includes;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
import java.sql.*;

public class DoConnection {
    public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String DBUSER = "system";
    public static final String DBPASS = "tiger";
    public static Connection getConnection() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con=DriverManager.getConnection(DBURL, DBUSER, DBPASS );

        return con;
    }
}
