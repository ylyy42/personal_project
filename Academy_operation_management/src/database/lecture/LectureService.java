package database.lecture;

import java.util.List;

public class LectureService {
	private LectureDao lectureDao;
	private LectureVo vo;
	
	public LectureService(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}
	
	// °­ÁÂ ¸ñ·Ï
	public String[][] Leclist() {
		return lectureDao.Lecprint();
	}
	
	// °­ÁÂ Ãß°¡
	public int Addlec(LectureVo vo) {
		return lectureDao.InsertLec(vo);
	}
	
	// °­ÁÂ »èÁ¦
	public int Deletelec(String lcode) {
		return lectureDao.DeleteLec(lcode);
	}
}
