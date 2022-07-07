package database.admin;

import java.util.List;


public class StudentsService {
	private StudentsDao studentsdao;
	
	public StudentsService(StudentsDao studentsdao) {
		this.studentsdao = studentsdao;
	}

	// 전체조회(학생 이름, 학교, 학년만 가져오기)
	public String[][] listAll() {
		return studentsdao.selectMemberAll();
	}
	
	// 학생정보가져오기
	public List<StudentsVo> infor(String name) {
		return studentsdao.selectMember(name);
	}
	
	// 학생 강좌 정보
	public String[][] listLec(String name) {
		return studentsdao.selectMemberLec(name);
	}
}
