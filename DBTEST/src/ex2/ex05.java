package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex05 {
	public static void main(String[] args) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {
			conn = util.getConnection();

			System.out.println("접속성공");
			
			StringBuffer query = new StringBuffer();
			query.append("update member");
			query.append(" set memberpw = ?, nickname = ?");
			query.append(" where num = ?");
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, "4321");
			pstmt.setString(2, "nnnn");
			pstmt.setInt(3, 6);
			result = pstmt.executeUpdate(); // insert할때는 처음에 반환값이 숫자이기때문에 esecuteQuery함수를 쓸수가없다
			System.out.println(result + "행이 수정되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			util.close(pstmt);
			util.close(conn);
		}
	}
}
