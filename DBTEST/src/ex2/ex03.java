package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex03 {
	public static void main(String[] args) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		try {
			conn = util.getConnection();

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from member where num = ?");
			pstmt.setInt(1, 2); // 첫번째 물음표에 2를 넣는다.
			rs = pstmt.executeQuery();
			
			// 값을가져오는부분
			if(rs.next()) {
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
