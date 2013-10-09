import java.sql.DriverManager;

import java.sql.*;

import oracle.jdbc.driver.*;

import oracle.sql.*;

public class TestOracle {

	/**
	 * 
	 * 
	 @param args
	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		try {

			DriverManager.registerDriver(

			new oracle.jdbc.driver.OracleDriver());

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "goll", "goll");

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * from amigos");

			 

			while (rs.next())

			{

				System.

				// out.println(rs.getInt("id"));
				out.println(rs.getString("nick"));

			}

			rs.close();

			st.close();

			conn.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}