package database.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	// 학생 출석 정보
	public String[][] listAtt(String name) {
		return studentsdao.selectMemberAtt(name);
	}
	
	// 학생 성적 정보
	public String[][] listSco(String name) {
		return studentsdao.selectMemberScore(name);
	}
	
	// 사진 저장
	public void pictureIn(String pname, String name) throws FileNotFoundException {
		studentsdao.savePicture(pname, name);
	}
	
}
