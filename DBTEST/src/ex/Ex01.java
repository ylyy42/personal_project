package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
	public static void main(String[] args) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			System.out.println("Ŭ���� �ε�!");

			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##green", "green1234"); 

			System.out.println("���Ӽ���");

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
