package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBServices {

    String url;
    Connection aConnection;
    Statement aStatement;
    private static DBServices anInstance = null;

    
    
    private DBServices() {

        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Properties props = new Properties();
            props.put("charSet", "windows-1256");
//            url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=clinc.mdb;DriverID=22";
//            aConnection = DriverManager.getConnection(url, props);
//            aStatement = aConnection.createStatement();
            aConnection = DriverManager.getConnection("jdbc:ucanaccess://clinc.mdb");
            aStatement = aConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DBServices getInstance() {
        if (anInstance == null) {
            return anInstance = new DBServices();
        }
        return anInstance;
    }

    public Connection getConnection() {
        return this.aConnection;
    }

    public void closeConnection() throws SQLException {
        this.aConnection.close();
    }

    public Statement getaStatement() {
        return aStatement;
    }

}
