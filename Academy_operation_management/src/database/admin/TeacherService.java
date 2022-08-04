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

	// 등록
	public int regist(TeacherVo vo) {
		return teacherDao.insertMember(vo);
	}

	// 전체조회
	public String[][] listAll() {
		return teacherDao.selectMemberAll();
	}

	// 선생님정보가져오기 (리스트)
	public List<TeacherVo> infor(String name) {
		return teacherDao.selectMember(name);
	}

	// 선생님 강좌 정보
	public String[][] listLec(String code) {
		return teacherDao.selectMemberLec(code);
	}

	// 선생님 강좌 정보
	public String[][] listStu(String code) {
		return teacherDao.selectstu(code);
	}

	// 선생님 정보
	public String[] inforNotList(String code) {
		return teacherDao.selectMemberAllNotList(code);
	}

	// 선생님정보 수정하기
	public int updatetea(TeacherVo vo, String code) {
		return teacherDao.updateMember(vo, code);
	}

	// 사진저장
	public int InsertPic(File fc, String code) throws FileNotFoundException {
		return teacherDao.pictureIn(fc, code);
	}

	// 사진 출력
	public BufferedImage PrintPic(String code) throws IOException, SQLException {
		return teacherDao.picturePrint(code);
	}

}
