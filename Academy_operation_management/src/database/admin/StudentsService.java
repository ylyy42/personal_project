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
	
	// ���� ���� ���
	public String[][] Feelist() {
		return studentsdao.selectFee();
	}
	
	// �л����
	public int regist(StudentsVo vo) {
		return studentsdao.insertMember(vo);
	}

	// ��ü��ȸ(�л� �̸�, �б�, �г⸸ ��������)
	public String[][] listAll() {
		return studentsdao.selectMemberAll();
	}
	
	// �л������������� (����Ʈ)
	public List<StudentsVo> infor(String name) {
		return studentsdao.selectMember(name);
	}
	
	// �л�������������
	public String[] inforNotList(String code) {
		return studentsdao.selectMemberAllNotList(code);
	}
	
	// �л����� �����ϱ�
	public int updatestu(StudentsVo vo, int code) {
		return studentsdao.updateMember(vo, code);
	}
	
	// �л� ���� ����
	public String[][] listLec(String code) {
		return studentsdao.selectMemberLec(code);
	}
	
	// �л� ���¸�� �߰�
	public String[][] lecAdd() {
		return studentsdao.selectLec();
	}
	
	// �л� ���� �߰�
	public int stuLecAdd(StudentsLecVo vo) {
		return studentsdao.insertLec(vo);
	}
	
	// �л� ���� ����
	public int stuLecDelete(int sCode, int lCode) {
		return studentsdao.deleteLec(sCode, lCode);
	}
	
	// �л� �⼮ ����
	public String[][] listAtt(String code) {
		return studentsdao.selectMemberAtt(code);
	}
	
	// �л� ���� ����
	public String[][] listSco(String code) {
		return studentsdao.selectMemberScore(code);
	}
	
	// �л� �⼮
	public int Checkin(StudentsAttVo vo) {
		return studentsdao.StuIncheck(vo);
	}
	
	// �л� ���
	public int Checkout(StudentsAttVo vo) {
		return studentsdao.StuOutcheck(vo);
	}
	
	// �л� ���� ����
	public int insertScore(StudentsScoVo vo) {
		return studentsdao.StuScoreIn(vo);
	}
	
	// ��������
	public int InsertPic(File fc, String code) throws FileNotFoundException {
		return studentsdao.pictureIn(fc, code);
	}
	
	// ���� ���
	public BufferedImage PrintPic(String code) throws IOException, SQLException {
		return studentsdao.picturePrint(code);
	}
	
}
