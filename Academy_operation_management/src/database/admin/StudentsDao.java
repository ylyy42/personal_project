package database.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnectionUtil;

public class StudentsDao {
	private JdbcConnectionUtil util;

	public StudentsDao() {
		util = JdbcConnectionUtil.getInstance();
	}

	public int insertMember(StudentsVo vo) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {
			conn = util.getConnection();

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO students (code, name, resident_id, phone,");
			query.append(" email, school, grade, parents_name, parents_phone, address) VALUES (");
			query.append(" students_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getResidentId());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getSchool());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(6, vo.getParentsName());
			pstmt.setString(6, vo.getParentsPhone());
			pstmt.setString(6, vo.getAddress());
			result = pstmt.executeUpdate(); // insert할때는 처음에 반환값이 숫자이기때문에 esecuteQuery함수를 쓸수가없다
			System.out.println(result + "행이 삽입되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 학생 이름, 학교, 학년 가져오기
	public String[][] selectMemberAll() {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsVo> result = new ArrayList<>();
		String[][] tConts = null;
		
		try {
			// DriverManager로 데이터베이스에 실제로 접속
			conn = util.getConnection();

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from students ORDER BY name");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

				result.add(vo);
			}
			
			tConts = new String[result.size()][3];
			
			for(int i = 0; i < result.size(); i++) {
				for(int j = 0; j < 3; j++) {
					tConts[i][j] = result.get(i).getName();
					tConts[i][++j] = result.get(i).getSchool();
					tConts[i][++j] = result.get(i).getGrade();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return tConts;
	}
	
	// 학생정보 가져오기
		public List<StudentsVo> selectMember(String name) {
			Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
			PreparedStatement pstmt = null; // 쿼리문사용을위한
			ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
			List<StudentsVo> result = new ArrayList<>();
			
			try {
				// DriverManager로 데이터베이스에 실제로 접속
				conn = util.getConnection();

				System.out.println("접속성공");
				pstmt = conn.prepareStatement("select * from students WHERE name = '" + name + "'");
				rs = pstmt.executeQuery();

				// 값을가져오는부분
				while (rs.next()) {
					StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

					result.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			return result;
		}
		
		// 학생 강좌 정보
		public String[][] selectMemberLec(String name) {
			Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
			PreparedStatement pstmt = null; // 쿼리문사용을위한
			ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
			List<StudentsLecVo> result = new ArrayList<>();
			String[][] lecConts = null;
			
			try {
				// DriverManager로 데이터베이스에 실제로 접속
				conn = util.getConnection();

				System.out.println("접속성공");
				pstmt = conn.prepareStatement("SELECT l.NAME , sl.START_DATE , sl.GIVE_DATE , sl.GIVING , sl.ing\r\n"
						+ "FROM STUDENTS s , LECTURE l , STUDENT_LECTUREINFO sl \r\n"
						+ "WHERE s.NAME = '" + name +"' AND s.CODE = sl.S_CODE AND l.CODE = sl.L_CODE ");
				rs = pstmt.executeQuery();

				// 값을가져오는부분
				while (rs.next()) {
					StudentsLecVo vo = new StudentsLecVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

					result.add(vo);
				}
				
				lecConts = new String[result.size()][5];
				
				for(int i = 0; i < result.size(); i++) {
					for(int j = 0; j < 5; j++) {
						lecConts[i][j] = result.get(i).getLecName();
						lecConts[i][++j] = result.get(i).getStartDate();
						lecConts[i][++j] = result.get(i).getGiveDate();
						lecConts[i][++j] = result.get(i).getGiving();
						lecConts[i][++j] = result.get(i).getIng();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			return lecConts;
		}

}
