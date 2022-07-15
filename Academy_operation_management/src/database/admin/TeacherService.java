package database.admin;

import java.util.List;

public class TeacherService {
	private TeacherDao teacherDao;
	private TeacherVo vo;
	
	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	// ��ü��ȸ
	public String[][] listAll() {
		return teacherDao.selectMemberAll();
	}
	
	// ������������������ (����Ʈ)
	public List<TeacherVo> infor(String name) {
		return teacherDao.selectMember(name);
	}
	
	// �л� ���� ����
	public String[][] listLec(String code) {
		return teacherDao.selectMemberLec(code);
	}
	
	// �л� ���� ����
	public String[][] listStu(String code) {
		return teacherDao.selectstu(code);
	}

}
