package database.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		int result = 0; // insert�Ҷ� ��ȯ���� ���� , ����Ŭ���� ���� �����ϸ� '1���� ��¼�� �ϰ� �տ� 1�� ����'
		try {
			conn = util.getConnection();

			System.out.println("���Ӽ���");

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
			result = pstmt.executeUpdate(); // insert�Ҷ��� ó���� ��ȯ���� �����̱⶧���� esecuteQuery�Լ��� ����������
			System.out.println(result + "���� ���ԵǾ����ϴ�.");

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

	// �л� �̸�, �б�, �г� ��������
	public String[][] selectMemberAll() {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<StudentsVo> result = new ArrayList<>();
		String[][] tConts = null;

		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * from students ORDER BY name");
			rs = pstmt.executeQuery();

			// �����������ºκ�
			while (rs.next()) {
				StudentsVo vo = new StudentsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

				result.add(vo);
			}

			tConts = new String[result.size()][3];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
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

	// �л����� ��������
	public List<StudentsVo> selectMember(String name) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<StudentsVo> result = new ArrayList<>();

		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * from students WHERE name = '" + name + "'");
			rs = pstmt.executeQuery();

			// �����������ºκ�
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

	// �л� ���� ����
	public String[][] selectMemberLec(String name) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<StudentsLecVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT l.NAME , sl.START_DATE , sl.GIVE_DATE , sl.GIVING , sl.ing\r\n"
					+ "FROM STUDENTS s , LECTURE l , STUDENT_LECTUREINFO sl \r\n" + "WHERE s.NAME = '" + name
					+ "' AND s.CODE = sl.S_CODE AND l.CODE = sl.L_CODE ");
			rs = pstmt.executeQuery();

			// �����������ºκ�
			while (rs.next()) {
				StudentsLecVo vo = new StudentsLecVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				result.add(vo);
			}

			lecConts = new String[result.size()][5];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 5; j++) {
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

	// �л� �⼮ ����
	public String[][] selectMemberAtt(String name) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<StudentsAttVo> result = new ArrayList<>();
		String[][] AttConts = null;

		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT as2.INTIME, as2.OUTTIME, as2.early, as2.earlyWhy \r\n"
					+ "FROM STUDENTS s , ATTENDANCE_STUDENT as2 \r\n" + "WHERE s.Name = '" + name
					+ "' AND s.CODE = as2.STUDENT_CODE ");
			rs = pstmt.executeQuery();

			// �����������ºκ�
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return AttConts;
	}

	// �л� ���� ����
	public String[][] selectMemberScore(String name) {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<StudentsScoVo> result = new ArrayList<>();
		String[][] ScoConts = null;

		try {
			// DriverManager�� �����ͺ��̽��� ������ ����
			conn = util.getConnection();

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT s2.edate, s2.ename, s2.escore\r\n" + "FROM STUDENTS s , SCORE s2 \r\n"
					+ "WHERE s.Name = '" + name + "' AND s.CODE = s2.scode");
			rs = pstmt.executeQuery();

			// �����������ºκ�
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return ScoConts;
	}

	// �̹��� �����ϱ�
	public void savePicture(String pname, String name) throws FileNotFoundException {
		Connection conn = null; // �����ͺ��̽� ������ ���� Ŀ�ؼ� ��ü
		PreparedStatement pstmt = null; // ���������������
		try {
			conn = util.getConnection();

			System.out.println("���Ӽ���");

			File f = new File("./images/" + pname + ".jpg");
			FileInputStream fis = new FileInputStream(f);
			pstmt = conn.prepareStatement("UPDATE students SET SPICTURE = ? WHERE name = ?");
			pstmt.setBinaryStream(1, fis, (int) f.length());
			pstmt.setString(2, name);

			int rownum = pstmt.executeUpdate();

			if (rownum > 0) {
				System.out.println("���Լ���");
			} else {
				System.out.println("���Խ���");
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

//	public void printPicture(String name) throws IOException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = util.getConnection();
//
//			System.out.println("���Ӽ���");
//
//			pstmt = conn.prepareStatement("SELECT SPICTURE FROM STUDENTS WHERE name = '" + name + "'");
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				do {
//					InputStream is = rs.getBinaryStream("spicture");
//					FileOutputStream fos = new FileOutputStream("../" + name + ".jpg");
//
//					byte[] buf = new byte[512];
//					int len;
//					while (true) {
//						len = is.read(buf);
//						if (len <= 0)
//							break;
//
//						fos.write(buf, 0, len);
//					}
//
//				} while (rs.next());
//			} else {
//				System.out.println("�����Ͱ� �����ϴ�.");
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}

}
