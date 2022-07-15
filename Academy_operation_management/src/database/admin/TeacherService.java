package database.admin;

import java.util.List;

public class TeacherService {
	private TeacherDao teacherDao;
	private TeacherVo vo;
	
	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	// 전체조회
	public String[][] listAll() {
		return teacherDao.selectMemberAll();
	}
	
	// 선생님정보가져오기 (리스트)
	public List<TeacherVo> infor(String name) {
		return teacherDao.selectMember(name);
	}
	
	// 학생 강좌 정보
	public String[][] listLec(String code) {
		return teacherDao.selectMemberLec(code);
	}
	
	// 학생 강좌 정보
	public String[][] listStu(String code) {
		return teacherDao.selectstu(code);
	}

}
