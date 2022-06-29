package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex04 {
	public static void main(String[] args) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		int result = 0; // insert�Ҷ� ��ȯ���� ���� , ����Ŭ���� ���� �����ϸ� '1���� ��¼�� �ϰ� �տ� 1�� ����'
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			System.out.println("Ŭ���� �ε�!");

			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##green", "green1234"); 

			System.out.println("���Ӽ���");
			
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO member (num, memberid, memberpw, nickname, regdate)");
			query.append(" VALUES (member_seq.nextval, ?,");
			query.append(" ?, ?, sysdate)");
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "tester4");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "testnick1");
			result = pstmt.executeUpdate(); // insert�Ҷ��� ó���� ��ȯ���� �����̱⶧���� esecuteQuery�Լ��� ����������
			System.out.println(result + "���� ���ԵǾ����ϴ�.");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
