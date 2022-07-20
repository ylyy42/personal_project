package database.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import database.JdbcConnectionUtil;

public class TeacherDao {
	private JdbcConnectionUtil util;
	private Connection conn;

	public TeacherDao() {
		util = JdbcConnectionUtil.getInstance();
		try {
			conn = util.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 등록하기
	public int insertMember(TeacherVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append(
					"INSERT INTO teacher (code, name, resident_id, phone, email, YEAR, sal, major, address, account_number)");
			query.append("VALUES (teacher_seq.nextval,?,?,?,");
			query.append("?,?,?,?,?,?)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getResidentId());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getYear());
			pstmt.setString(6, vo.getSal());
			pstmt.setString(7, vo.getMajor());
			pstmt.setString(8, vo.getAddress());
			pstmt.setString(9, vo.getAccountNumber());
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
		}
		return result;
	}

	// 선생님 리스트 가져오기
	public String[][] selectMemberAll() {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<TeacherVo> result = new ArrayList<>();
		String[][] tConts = null;

		try {
			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * \r\n" + "from teacher \r\n" + "ORDER BY code");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				TeacherVo vo = new TeacherVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				result.add(vo);
			}

			tConts = new String[result.size()][3];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					tConts[i][j] = result.get(i).getCode();
					tConts[i][++j] = result.get(i).getName();
					tConts[i][++j] = result.get(i).getMajor();
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
		}

		return tConts;
	}

	// 선생님 정보 가져오기
	public List<TeacherVo> selectMember(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<TeacherVo> result = new ArrayList<>();

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from teacher WHERE code = " + code);
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				TeacherVo vo = new TeacherVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

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
		}

		return result;
	}

	// 선생님 강의 정보
	public String[][] selectMemberLec(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<TeacherVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT l.NAME , l.LECTURE_STARTDATE , count(sl.S_CODE)\r\n"
					+ "FROM LECTURE l , STUDENT_LECTUREINFO sl , STUDENTS s , TEACHER t \r\n"
					+ "WHERE l.CODE = sl.L_CODE AND s.CODE = sl.S_CODE AND t.CODE = l.TEACHER_CODE AND t.CODE = " + code
					+ "\r\n" + "GROUP BY l.NAME , l.LECTURE_STARTDATE ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				TeacherVo vo = new TeacherVo(rs.getString(1), rs.getString(2), rs.getString(3));

				result.add(vo);
			}

			lecConts = new String[result.size()][3];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					lecConts[i][j] = result.get(i).getlName();
					lecConts[i][++j] = result.get(i).getLs();
					lecConts[i][++j] = result.get(i).getMembers();
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
		}

		return lecConts;
	}

	// 선생님 강의 정보
	public String[][] selectstu(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<TeacherVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT s.NAME , l.NAME , sl.ING \r\n"
					+ "FROM STUDENTS s, TEACHER t , STUDENT_LECTUREINFO sl , LECTURE l \r\n"
					+ "WHERE s.CODE = sl.S_CODE AND t.CODE = l.TEACHER_CODE AND sl.L_CODE = l.CODE AND t.CODE = "
					+ code);
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				TeacherVo vo = new TeacherVo(rs.getString(1), rs.getString(2), rs.getString(3));

				result.add(vo);
			}

			lecConts = new String[result.size()][3];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					lecConts[i][j] = result.get(i).getlName();
					lecConts[i][++j] = result.get(i).getLs();
					lecConts[i][++j] = result.get(i).getMembers();
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
		}

		return lecConts;
	}

	// 선생님 정보 가져오기 (리스트 X)
	public String[] selectMemberAllNotList(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<TeacherVo> result = new ArrayList<>();
		String[] conts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from teacher WHERE code = " + code);
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				TeacherVo vo = new TeacherVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				result.add(vo);
			}

			conts = new String[] { result.get(0).getName(), result.get(0).getResidentId(), result.get(0).getPhone(),
					result.get(0).getEmail(), result.get(0).getYear(), result.get(0).getSal(), result.get(0).getMajor(),
					result.get(0).getAccountNumber(), result.get(0).getAddress() };

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
		}

		return conts;
	}

	// 선생님 정보 수정하기
	public int updateMember(TeacherVo vo, String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("update teacher");
			query.append(
					" set name = ?, resident_id = ?, phone = ?, email = ?, year = ?, sal = ?, major = ?, address = ?, account_number = ? ");
			query.append("WHERE CODE = ?");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getResidentId());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getYear());
			pstmt.setString(6, vo.getSal());
			pstmt.setString(7, vo.getMajor());
			pstmt.setString(8, vo.getAccountNumber());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, code);
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
		}

		return result;
	}

	// 사진 저장하기
	public int pictureIn(File fc, String code) throws FileNotFoundException {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("UPDATE TEACHER SET TPICTURE = ? WHERE CODE = ?");

			System.out.println(query);

			FileInputStream fis = new FileInputStream(fc);
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setBinaryStream(1, fis, (int) fc.length());
			pstmt.setString(2, code);

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
		}
		return result;
	}

	// 사진 뿌려주기
	public BufferedImage picturePrint(String code) throws IOException, SQLException {

		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴

		System.out.println("접속성공");
		pstmt = conn.prepareStatement(
				"SELECT t.TPICTURE FROM TEACHER t WHERE code = " + code + " AND NOT t.tpicture IS NULL ");
		rs = pstmt.executeQuery();
		rs.next();

		if (rs.getRow() == 0) {
			System.out.println("등록된 사진이 없습니다.");
		} else {
			System.out.println("등록된 사진이 있습니다.");
			InputStream in = rs.getBinaryStream(1);
			BufferedImage bi = ImageIO.read(in);
			in.close();

			return bi;
		}

		return null;
	}

}
