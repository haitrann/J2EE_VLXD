package vlxd.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionService {
	
	protected static void loadJDBCDriver() throws Exception {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("SQL JDBC Driver not found ...");
        }
    }
	
	public static Connection getConnection() throws Exception {
        Connection connect = null;
        if (connect == null) {
        	loadJDBCDriver();
            try {                
            	String MYSQL = "jdbc:mysql://localhost:3306/mydb";
    			String USER = "root";                                                                                                                                 
    			String PASS = "230898";
    			connect = DriverManager.getConnection(MYSQL, USER, PASS);
            } catch (Exception e) {
            	throw new Exception("Can not access to Database Server ..." + e.getMessage());
            }
        }
        return connect;
    }
}
