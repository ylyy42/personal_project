package database.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcConnectionUtil;
import database.admin.StudentsVo;

public class LectureDao {
	private JdbcConnectionUtil util;
	private Connection conn;

	public LectureDao() {
		util = JdbcConnectionUtil.getInstance();
		try {
			conn = util.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���¸��
	public String[][] Lecprint() {
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		List<LectureVo> result = new ArrayList<>();
		String[][] lecConts = null;

		try {

			System.out.println("���Ӽ���");
			pstmt = conn.prepareStatement("SELECT l.code, l.NAME , l.LECTURE_STARTDATE , t.NAME \r\n"
					+ "FROM lecture l, TEACHER t \r\n" + "WHERE l.TEACHER_CODE = t.CODE \r\n" + "ORDER BY l.CODE");
			rs = pstmt.executeQuery();

			// �����������ºκ�
			while (rs.next()) {
				LectureVo vo = new LectureVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

				result.add(vo);
			}

			lecConts = new String[result.size()][4];

			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 4; j++) {
					lecConts[i][j] = result.get(i).getlCode();
					lecConts[i][++j] = result.get(i).getlName();
					lecConts[i][++j] = result.get(i).getLectureStartdate();
					lecConts[i][++j] = result.get(i).gettName();
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

	// ���µ��
	public int InsertLec(LectureVo vo) {
		PreparedStatement pstmt = null; // ���������������
		int result = 0; // insert�Ҷ� ��ȯ���� ���� , ����Ŭ���� ���� �����ϸ� '1���� ��¼�� �ϰ� �տ� 1�� ����'
		try {

			System.out.println("���Ӽ���");

			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO LECTURE (code, name, LECTURE_FEE, QUOTA, DAYS, TEACHER_CODE, LECTURE_STARTDATE)");
			query.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
			System.out.println(query);

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getlCode());
			pstmt.setString(2, vo.getlName());
			pstmt.setString(3, vo.getlFee());
			pstmt.setString(4, vo.getQuota());
			pstmt.setString(5, vo.getDays());
			pstmt.setString(6, vo.gettCode());
			pstmt.setString(7, vo.getLectureStartdate());
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
		}
		return result;
	}

	// ���� ����
	public int DeleteLec(String lCode) {
		PreparedStatement pstmt = null; // ���������������
		int result = 0; // insert�Ҷ� ��ȯ���� ���� , ����Ŭ���� ���� �����ϸ� '1���� ��¼�� �ϰ� �տ� 1�� ����'
		try {

			System.out.println("���Ӽ���");

			StringBuffer query = new StringBuffer();
			query.append("DELETE LECTURE WHERE code = ?");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, lCode);

			System.out.println(query);

			result = pstmt.executeUpdate(); // insert�Ҷ��� ó���� ��ȯ���� �����̱⶧���� esecuteQuery�Լ��� ����������
			System.out.println(result + "���� �����Ǿ����ϴ�.");

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

}
