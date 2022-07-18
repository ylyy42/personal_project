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

}
