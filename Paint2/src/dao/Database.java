package dao;
import java.sql.*;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/paint";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null;
	static Statement stmt = null;

	public static void init(){
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
			stmt = conn.createStatement();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public static void updateSql(String sql)
	{
		try{
			
			stmt.executeUpdate(sql);


		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
	}
	
	public static ResultSet getSql(String sql)
	{
		try{
			ResultSet rs;
			rs = stmt.executeQuery(sql);
			
			return rs;
			
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		return null;
	}
	
	public static void close()
	{

			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			//end finally try
		}//end try
	}
}