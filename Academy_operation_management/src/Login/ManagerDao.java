package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {

	private JdbcConnectionUtil util;

	public ManagerDao() {
		util = JdbcConnectionUtil.getInstance();
	}

	// C
	public int insertMember(ManagerVo vo) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {
			conn = util.getConnection();

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO manager (num, name, id, password, RESIDENT_ID, PHONE, EMAIL)");
			query.append(" VALUES (manager_seq.nextval, ?,");
			query.append(" ?, ?, ?, ?, ?)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getResidentId());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());
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

	// R
	public ManagerVo selectMember(int num) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		ManagerVo result = null;
		try {
			conn = util.getConnection();

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from manager where num = ?");
			pstmt.setInt(1, num); // 첫번째 물음표에 num를 넣는다.
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			if (rs.next()) {
				result = new ManagerVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
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

	public List<ManagerVo> selectMemberAll() {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<ManagerVo> result = new ArrayList<>();
		try {
			// DriverManager로 데이터베이스에 실제로 접속
			conn = util.getConnection();

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from manager");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				ManagerVo vo = new ManagerVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

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

	// U
	public int updateMember(ManagerVo vo) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {
			conn = util.getConnection();

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("update member");
			query.append(" set password = ?, email = ?");
			query.append(" where num = ?");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setInt(3, vo.getNum());
			result = pstmt.executeUpdate(); // insert할때는 처음에 반환값이 숫자이기때문에 esecuteQuery함수를 쓸수가없다
			System.out.println(result + "행이 수정되었습니다.");

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

	// D
	public int deleteMember(int num) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {
			conn = util.getConnection();

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("delete from member");
			query.append(" where num = ?");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate(); // insert할때는 처음에 반환값이 숫자이기때문에 esecuteQuery함수를 쓸수가없다
			System.out.println(result + "행이 삭제되었습니다.");

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

	// 로그인
	public boolean list(ManagerVo vo) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		Statement stmt = null; // 쿼리문사용을위한
		ResultSet rs = null;

		try {
			conn = util.getConnection();

			System.out.println("접속성공");
			String query = "SELECT * FROM manager WHERE id = '" + vo.getId() + "' AND password = '" + vo.getPassword()
					+ "'";
			System.out.println(query);

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected....");
			} else {
				return true;
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
			if (stmt != null) {
				try {
					stmt.close();
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

		return false;
	}
	
	// 아이디 중복확인체크
	public boolean check(ManagerVo vo) {
		Connection conn = null; // 데이터베이스 연결을 위한 커넥션 객체
		Statement stmt = null; // 쿼리문사용을위한
		ResultSet rs = null;

		try {
			conn = util.getConnection();

			System.out.println("접속성공");
			String query = "SELECT * FROM manager WHERE id = '" + vo.getId() + "'";

			stmt = conn.prepareStatement(query);
			System.out.println(query);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("중복되는 아이디가 없습니다.");
			} else {
				System.out.println("중복되는 아이디가 있습니다.");
				return false;
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
			if (stmt != null) {
				try {
					stmt.close();
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

		return true;
	}
	
}
