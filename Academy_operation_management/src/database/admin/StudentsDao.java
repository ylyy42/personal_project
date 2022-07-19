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

public class StudentsDao {
	private JdbcConnectionUtil util;
	private Connection conn;

	public StudentsDao() {
		util = JdbcConnectionUtil.getInstance();
		try {
			conn = util.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 등록하기
	public int insertMember(StudentsVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

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
			pstmt.setString(7, vo.getParentsName());
			pstmt.setString(8, vo.getParentsPhone());
			pstmt.setString(9, vo.getAddress());
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

	// 학생 강좌등록하기
	public int insertLec(StudentsLecVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO STUDENT_LECTUREINFO (s_code, l_code, give_date, giving, ing)");
			query.append(" VALUES (");
			query.append(" ?, ?, sysdate + 15, ?, ?)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getsCode());
			pstmt.setString(2, vo.getlCode());
			pstmt.setString(3, "미납");
			pstmt.setString(4, "수강중");

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

	// 학생 강좌삭제하기
	public int deleteLec(int sCode, int lCode) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("DELETE FROM STUDENT_LECTUREINFO ");
			query.append("WHERE S_CODE = ? AND L_CODE = ?");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, sCode);
			pstmt.setInt(2, lCode);

			System.out.println(query);

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

	// 학생 정보 수정하기
	public int updateMember(StudentsVo vo, int code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("update students");
			query.append(
					" set name = ?, resident_id = ?, phone = ?, email = ?, school = ?, grade = ?, parents_name = ?, parents_phone = ?, address = ? ");
			query.append("WHERE CODE = ?");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getResidentId());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getSchool());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getParentsName());
			pstmt.setString(8, vo.getParentsPhone());
			pstmt.setString(9, vo.getAddress());
			pstmt.setInt(10, code);
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

	// 학생 정보 수정하기
	public int updateFee(StudentsFeeVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("UPDATE STUDENT_LECTUREINFO SET giving = '수납완료' WHERE s_code = ?");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getsCode());
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

	// 학생 이름, 학교, 학년 가져오기 (리스트)
	public String[][] selectMemberAll() {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsVo> result = new ArrayList<>();
		String[][] tConts = null;

		try {
			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from students ORDER BY code");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				result.add(vo);
			}

			tConts = new String[result.size()][4];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 4; j++) {
					tConts[i][j] = result.get(i).getCode();
					tConts[i][++j] = result.get(i).getName();
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
		}

		return tConts;
	}

	// 학생 이름, 학교, 학년 가져오기 (리스트 X)
	public String[] selectMemberAllNotList(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsVo> result = new ArrayList<>();
		String[] conts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from students WHERE code = " + code);
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				result.add(vo);
			}

			conts = new String[] { result.get(0).getName(), result.get(0).getResidentId(), result.get(0).getPhone(),
					result.get(0).getSchool(), result.get(0).getGrade(), result.get(0).getParentsName(),
					result.get(0).getParentsPhone(), result.get(0).getEmail(), result.get(0).getAddress() };

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

	// 학생정보 가져오기
	public List<StudentsVo> selectMember(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsVo> result = new ArrayList<>();

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("select * from students WHERE code = " + code);
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

	// 학생 강좌 정보
	public String[][] selectMemberLec(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsLecVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT l.code, l.NAME , sl.GIVE_DATE , sl.GIVING,t.NAME\r\n"
					+ "FROM STUDENTS s , LECTURE l , STUDENT_LECTUREINFO sl, TEACHER t \r\n" + "WHERE s.CODE = " + code
					+ "\r\n"
					+ "AND s.CODE = sl.S_CODE AND l.CODE = sl.L_CODE AND l.TEACHER_CODE = t.CODE ORDER BY l.code ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsLecVo vo = new StudentsLecVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				result.add(vo);
			}

			lecConts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 5; j++) {
					lecConts[i][j] = result.get(i).getlCode();
					lecConts[i][++j] = result.get(i).getLecName();
					lecConts[i][++j] = result.get(i).getTname();
					lecConts[i][++j] = result.get(i).getGiveDate();
					lecConts[i][++j] = result.get(i).getGiving();
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

	// 학생 강좌 추가목록
	public String[][] selectLec() {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsLecVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement(
					"SELECT l.CODE,l.NAME, l.LECTURE_FEE, t.Name, l.QUOTA, count(sl.S_CODE) AS 학생수 \r\n"
							+ "FROM LECTURE l, TEACHER t, STUDENT_LECTUREINFO sl, STUDENTS s  \r\n"
							+ "WHERE l.TEACHER_CODE = t.CODE AND sl.L_CODE(+) = l.CODE AND sl.S_CODE = s.CODE(+)\r\n"
							+ "GROUP BY l.CODE, l.name, l.LECTURE_FEE , t.NAME , l.QUOTA \r\n" + "ORDER BY l.NAME ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsLecVo vo = new StudentsLecVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));

				result.add(vo);
			}

			lecConts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 5; j++) {
					int quota = Integer.parseInt(result.get(i).getQuota());
					int members = Integer.parseInt(result.get(i).getMembers());

					lecConts[i][j] = result.get(i).getlCode();
					lecConts[i][++j] = result.get(i).getLecName();
					lecConts[i][++j] = result.get(i).getLectureFee();
					lecConts[i][++j] = result.get(i).gettName();
					lecConts[i][++j] = String.valueOf(quota - members);
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

	// 학생 성적 저장
	public int StuScoreIn(StudentsScoVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO score (edate, ename, escore, scode)");
			query.append(" VALUES (?,?,?,?)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getEdate());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getEscore());
			pstmt.setString(4, vo.getScode());

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

	// 학생 출석하기
	public int StuIncheck(StudentsAttVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ATTENDANCE_STUDENT (student_code, intime)");
			query.append(" VALUES (?, sysdate)");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getsCode());

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

	// 학생 퇴실하기
	public int StuOutcheck(StudentsAttVo vo) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("update ATTENDANCE_STUDENT  SET outtime = sysdate");
			query.append(" WHERE STUDENT_CODE = ? AND OUTTIME IS NULL");

			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getsCode());

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

	// 학생 출석 정보
	public String[][] selectMemberAtt(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsAttVo> result = new ArrayList<>();
		String[][] AttConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement(
					"SELECT as2.INTIME, as2.OUTTIME \r\n" + "FROM STUDENTS s , ATTENDANCE_STUDENT as2 \r\n"
							+ "WHERE s.CODE = " + code + " AND s.CODE = as2.STUDENT_CODE ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsAttVo vo = new StudentsAttVo(rs.getString(1), rs.getString(2));

				result.add(vo);
			}

			AttConts = new String[result.size()][2];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 2; j++) {
					AttConts[i][j] = result.get(i).getInTime();
					AttConts[i][++j] = result.get(i).getOutTime();
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

		return AttConts;
	}

	// 학생 점수 정보
	public String[][] selectMemberScore(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsScoVo> result = new ArrayList<>();
		String[][] ScoConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT s2.edate, s2.ename, s2.escore\r\n" + "FROM STUDENTS s , SCORE s2 \r\n"
					+ "WHERE s.CODE =" + code + " AND s.CODE = s2.scode");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsScoVo vo = new StudentsScoVo(rs.getString(1), rs.getString(2), rs.getString(3));

				result.add(vo);
			}

			ScoConts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					ScoConts[i][j] = result.get(i).getEdate();
					ScoConts[i][++j] = result.get(i).getEname();
					ScoConts[i][++j] = result.get(i).getEscore();
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

		return ScoConts;
	}

	// 학생 강좌 정보
	public String[][] selectFee() {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsFeeVo> result = new ArrayList<>();
		String[][] conts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT s.CODE  ,s.NAME , sl.GIVE_DATE , l.LECTURE_FEE , sl.GIVING \r\n"
					+ "FROM STUDENT_LECTUREINFO sl , STUDENTs s , LECTURE l \r\n"
					+ "WHERE s.CODE = sl.S_CODE AND l.CODE = sl.L_CODE \r\n" + "ORDER BY s.CODE ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsFeeVo vo = new StudentsFeeVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				result.add(vo);
			}

			conts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 5; j++) {
					conts[i][j] = result.get(i).getsCode();
					conts[i][++j] = result.get(i).getsName();
					conts[i][++j] = result.get(i).getGiveDate();
					conts[i][++j] = result.get(i).getLectureFee();
					conts[i][++j] = result.get(i).getGiving();
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

		return conts;
	}

	// 사진 저장하기
	public int pictureIn(File fc, String code) throws FileNotFoundException {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		int result = 0; // insert할땐 반환값이 숫자 , 오라클에서 보면 삽입하면 '1행의 어쩌구 하고 앞에 1이 나옴'
		try {

			System.out.println("접속성공");

			StringBuffer query = new StringBuffer();
			query.append("UPDATE STUDENTS SET SPICTURE = ? WHERE CODE = ?");

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
		pstmt = conn.prepareStatement("SELECT s.SPICTURE FROM STUDENTS s WHERE code = "+ code +" AND NOT s.spicture IS NULL ");
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
