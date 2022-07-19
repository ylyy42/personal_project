package database.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class StudentsService {
	private StudentsDao studentsdao;
	private StudentsVo vo;
	
	public StudentsService(StudentsDao studentsdao) {
		this.studentsdao = studentsdao;
	}
	
	public int updateFee(StudentsFeeVo vo) {
		return studentsdao.updateFee(vo);
	}
	
	// 수납 관리 목록
	public String[][] Feelist() {
		return studentsdao.selectFee();
	}
	
	// 학생등록
	public int regist(StudentsVo vo) {
		return studentsdao.insertMember(vo);
	}

	// 전체조회(학생 이름, 학교, 학년만 가져오기)
	public String[][] listAll() {
		return studentsdao.selectMemberAll();
	}
	
	// 학생정보가져오기 (리스트)
	public List<StudentsVo> infor(String name) {
		return studentsdao.selectMember(name);
	}
	
	// 학생정보가져오기
	public String[] inforNotList(String code) {
		return studentsdao.selectMemberAllNotList(code);
	}
	
	// 학생정보 수정하기
	public int updatestu(StudentsVo vo, int code) {
		return studentsdao.updateMember(vo, code);
	}
	
	// 학생 강좌 정보
	public String[][] listLec(String code) {
		return studentsdao.selectMemberLec(code);
	}
	
	// 학생 강좌목록 추가
	public String[][] lecAdd() {
		return studentsdao.selectLec();
	}
	
	// 학생 강좌 추가
	public int stuLecAdd(StudentsLecVo vo) {
		return studentsdao.insertLec(vo);
	}
	
	// 학생 강좌 삭제
	public int stuLecDelete(int sCode, int lCode) {
		return studentsdao.deleteLec(sCode, lCode);
	}
	
	// 학생 출석 정보
	public String[][] listAtt(String code) {
		return studentsdao.selectMemberAtt(code);
	}
	
	// 학생 성적 정보
	public String[][] listSco(String code) {
		return studentsdao.selectMemberScore(code);
	}
	
	// 학생 출석
	public int Checkin(StudentsAttVo vo) {
		return studentsdao.StuIncheck(vo);
	}
	
	// 학생 퇴실
	public int Checkout(StudentsAttVo vo) {
		return studentsdao.StuOutcheck(vo);
	}
	
	// 학생 점수 저장
	public int insertScore(StudentsScoVo vo) {
		return studentsdao.StuScoreIn(vo);
	}
	
	// 사진저장
	public int InsertPic(File fc, String code) throws FileNotFoundException {
		return studentsdao.pictureIn(fc, code);
	}
	
	// 사진 출력
	public BufferedImage PrintPic(String code) throws IOException, SQLException {
		return studentsdao.picturePrint(code);
	}
	
}
