package includes;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
import java.sql.*;

public class DB {
    private static String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String DBUSER = "system";
    private static String DBPASS = "tiger";
    private static Connection connection;

    public DB() {

    }

    public static Connection openConnection() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS );

        return connection;

    }

    public static void closeConnection() throws Exception {
        connection.close();
    }

    public static Boolean commitDB() throws Exception {
        Statement commitStatement = connection.createStatement();
        return commitStatement.execute("COMMIT");
    }

}
