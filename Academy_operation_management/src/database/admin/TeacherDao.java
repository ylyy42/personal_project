package database.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	// ������ ����Ʈ ��������
	public String[][] selectMemberAll() {
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<TeacherVo> result = new ArrayList<>();
		String[][] tConts = null;

		try {
			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * \r\n" + "from teacher \r\n" + "ORDER BY code");
			rs = pstmt.executeQuery();

			// �����������ºκ�
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

	// ������ ���� ��������
	public List<TeacherVo> selectMember(String code) {
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<TeacherVo> result = new ArrayList<>();

		try {

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("select * from teacher WHERE code = " + code);
			rs = pstmt.executeQuery();

			// �����������ºκ�
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

	// ������ ���� ����
	public String[][] selectMemberLec(String code) {
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<TeacherVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT l.NAME , l.LECTURE_STARTDATE , count(sl.S_CODE)\r\n"
					+ "FROM LECTURE l , STUDENT_LECTUREINFO sl , STUDENTS s , TEACHER t \r\n"
					+ "WHERE l.CODE = sl.L_CODE AND s.CODE = sl.S_CODE AND t.CODE = l.TEACHER_CODE AND t.CODE = " + code
					+ "\r\n" + "GROUP BY l.NAME , l.LECTURE_STARTDATE ");
			rs = pstmt.executeQuery();

			// �����������ºκ�
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

	// ������ ���� ����
	public String[][] selectstu(String code) {
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<TeacherVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT s.NAME , l.NAME , sl.ING \r\n"
					+ "FROM STUDENTS s, TEACHER t , STUDENT_LECTUREINFO sl , LECTURE l \r\n"
					+ "WHERE s.CODE = sl.S_CODE AND t.CODE = l.TEACHER_CODE AND sl.L_CODE = l.CODE AND t.CODE = " + code);
			rs = pstmt.executeQuery();

			// �����������ºκ�
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

}
