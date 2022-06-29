package ex2;

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
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			
			// �����������ºκ�
			while(rs.next()) {
				MemberVo vo = new MemberVo(rs.getInt(1), rs.getString(2),rs.getString("MEMBERPW"),rs.getString(4));
				vo.setRegdate(rs.getDate("REGDATE"));
				
				System.out.println(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
	}
}
