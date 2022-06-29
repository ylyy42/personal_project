package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex02 {
	public static void main(String[] args) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			System.out.println("Ŭ���� �ε�!");

			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##green", "green1234"); 

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			
			// �����������ºκ�
			while(rs.next()) {
				MemberVo vo = new MemberVo(rs.getInt(1), rs.getString(2),rs.getString("MEMBERPW"),rs.getString(4));
				vo.setRegdate(rs.getDate("REGDATE"));
				
				System.out.println(vo);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
