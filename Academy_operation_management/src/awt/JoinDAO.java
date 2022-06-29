package awt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinDAO {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;

	public boolean list(JoinVo v) {
		
		boolean result = false;

		try {
			connDB();
			int mn = 001;

			String query = "INSERT INTO manager (manager_num, name, id, password, RESIDENT_ID, PHONE, email, GENDER) VALUES(" + (mn + 1) + "," +
			 v.getName() + "', '" + v.getId() + "', '" + v.getPassword() + "', '" + v.getResidentId() +"', '"
					+ v.getPhone() + "', '" + v.getEmail() + "', '" + v.getGender() + "'";
			System.out.println("SQL : " + query);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, Integer.toString(mn + 1));
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.setString(4, v.getPassword());
			pstmt.setString(5, v.getResidentId());
			pstmt.setString(5, v.getPhone());
			pstmt.setString(5, v.getEmail());
			pstmt.setString(5, v.getGender());
			
			int r = pstmt.executeUpdate();
			
			if(r > 0) result = true;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
