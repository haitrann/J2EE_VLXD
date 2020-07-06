package vlxd.mapper;

import java.sql.Connection;

import vlxd.dbconnection.DBConnectionService;

public class DBMapper {
    private Connection connection;
    
	public DBMapper() throws Exception {
		try {
			connection = DBConnectionService.getConnection();
		} catch (Exception e) {
			System.out.println("Failed in constructor method in MapperDB:" + e);
            e.printStackTrace();
            throw e;
		}
	}
	
	public DBMapper(Connection con) {
        connection = con;
    }
	
	public void closeConnection() throws Exception {
        try {
            getConnection().close();
        } catch (Exception e) {
            System.out.println("Failed in closeConnection method in MapperDB:" + e);
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
