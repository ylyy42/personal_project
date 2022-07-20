package database.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherService {
	private TeacherDao teacherDao;
	private TeacherVo vo;

	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	// ���
	public int regist(TeacherVo vo) {
		return teacherDao.insertMember(vo);
	}

	// ��ü��ȸ
	public String[][] listAll() {
		return teacherDao.selectMemberAll();
	}

	// ������������������ (����Ʈ)
	public List<TeacherVo> infor(String name) {
		return teacherDao.selectMember(name);
	}

	// ������ ���� ����
	public String[][] listLec(String code) {
		return teacherDao.selectMemberLec(code);
	}

	// ������ ���� ����
	public String[][] listStu(String code) {
		return teacherDao.selectstu(code);
	}

	// ������ ����
	public String[] inforNotList(String code) {
		return teacherDao.selectMemberAllNotList(code);
	}

	// ���������� �����ϱ�
	public int updatetea(TeacherVo vo, String code) {
		return teacherDao.updateMember(vo, code);
	}

	// ��������
	public int InsertPic(File fc, String code) throws FileNotFoundException {
		return teacherDao.pictureIn(fc, code);
	}

	// ���� ���
	public BufferedImage PrintPic(String code) throws IOException, SQLException {
		return teacherDao.picturePrint(code);
	}

}
