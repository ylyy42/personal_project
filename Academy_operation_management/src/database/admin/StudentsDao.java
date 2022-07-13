package database.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			pstmt = conn.prepareStatement("SELECT l.NAME , sl.GIVE_DATE , sl.GIVING , sl.ing,t.NAME \r\n"
					+ "FROM STUDENTS s , LECTURE l , STUDENT_LECTUREINFO sl, TEACHER t \r\n" + "WHERE s.CODE = " + code
					+ "\r\n" + "AND s.CODE = sl.S_CODE AND l.CODE = sl.L_CODE AND l.TEACHER_CODE = t.CODE  ");
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
					lecConts[i][j] = result.get(i).getLecName();
					lecConts[i][++j] = result.get(i).getTname();
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
					"SELECT l.CODE,l.NAME, l.LECTURE_FEE, t.Name, l.QUOTA, sl.GIVE_DATE, count(sl.S_CODE) AS 학생수 \r\n"
							+ "FROM LECTURE l, TEACHER t, STUDENT_LECTUREINFO sl, STUDENTS s  \r\n"
							+ "WHERE l.TEACHER_CODE = t.CODE AND sl.L_CODE(+) = l.CODE AND sl.S_CODE = s.CODE(+)\r\n"
							+ "GROUP BY l.CODE, l.name, l.LECTURE_FEE , t.NAME , l.QUOTA , sl.GIVE_DATE \r\n"
							+ "ORDER BY l.NAME ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsLecVo vo = new StudentsLecVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

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

	// 학생 출석 정보
	public String[][] selectMemberAtt(String code) {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		List<StudentsAttVo> result = new ArrayList<>();
		String[][] AttConts = null;

		try {

			System.out.println("접속성공");
			pstmt = conn.prepareStatement("SELECT as2.INTIME, as2.OUTTIME, as2.early, as2.earlyWhy \r\n"
					+ "FROM STUDENTS s , ATTENDANCE_STUDENT as2 \r\n" + "WHERE s.CODE = " + code
					+ " AND s.CODE = as2.STUDENT_CODE ");
			rs = pstmt.executeQuery();

			// 값을가져오는부분
			while (rs.next()) {
				StudentsAttVo vo = new StudentsAttVo(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));

				result.add(vo);
			}

			AttConts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 4; j++) {
					AttConts[i][j] = result.get(i).getInTime();
					AttConts[i][++j] = result.get(i).getOutTime();
					AttConts[i][++j] = result.get(i).getEarly();
					AttConts[i][++j] = result.get(i).getEarlyWhy();
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

	// 이미지 저장하기
	public void savePicture(String pname, String name) throws FileNotFoundException {
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		try {
			System.out.println("접속성공");

			File f = new File("./images/" + pname + ".jpg");
			FileInputStream fis = new FileInputStream(f);
			pstmt = conn.prepareStatement("UPDATE students SET SPICTURE = ? WHERE name = ?");
			pstmt.setBinaryStream(1, fis, (int) f.length());
			pstmt.setString(2, name);

			int rownum = pstmt.executeUpdate();

			if (rownum > 0) {
				System.out.println("삽입성공");
			} else {
				System.out.println("삽입실패");
			}

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
	}

	// public void printPicture(String name) throws IOException {
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	// try {
	// conn = util.getConnection();
	//
	// System.out.println("접속성공");
	//
	// pstmt = conn.prepareStatement("SELECT SPICTURE FROM STUDENTS WHERE name = '"
	// + name + "'");
	// rs = pstmt.executeQuery();
	//
	// if (rs.next()) {
	// do {
	// InputStream is = rs.getBinaryStream("spicture");
	// FileOutputStream fos = new FileOutputStream("../" + name + ".jpg");
	//
	// byte[] buf = new byte[512];
	// int len;
	// while (true) {
	// len = is.read(buf);
	// if (len <= 0)
	// break;
	//
	// fos.write(buf, 0, len);
	// }
	//
	// } while (rs.next());
	// } else {
	// System.out.println("데이터가 없습니다.");
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (rs != null) {
	// try {
	// rs.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// if (pstmt != null) {
	// try {
	// pstmt.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// }

}
