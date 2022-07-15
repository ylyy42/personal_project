package database.lecture;

import java.util.List;

public class LectureService {
	private LectureDao lectureDao;
	private LectureVo vo;
	
	public LectureService(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}
	
	// ���� ���
	public String[][] Leclist() {
		return lectureDao.Lecprint();
	}
	
	// ���� �߰�
	public int Addlec(LectureVo vo) {
		return lectureDao.InsertLec(vo);
	}
	
	// ���� ����
	public int Deletelec(String lcode) {
		return lectureDao.DeleteLec(lcode);
	}
}
