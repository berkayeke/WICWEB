package Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	public static Connection baglan() {

		Connection con = null;
	
		try {

			String driver = "com.mysql.jdbc.Driver";
			String connection = "jdbc:mysql://localhost:3306/wic?allowMultiQueries=true";
			String user = "root";
			String password = "";
			Class.forName(driver);
			
			con = DriverManager.getConnection(connection, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void baglantiKapa(Connection con) {
		
		try
		{
			if (!con.isClosed()) {
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}


}
