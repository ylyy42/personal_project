package database.admin;

import java.io.FileNotFoundException;
import java.util.List;


public class StudentsService {
	private StudentsDao studentsdao;
	private StudentsVo vo;
	
	public StudentsService(StudentsDao studentsdao) {
		this.studentsdao = studentsdao;
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
	
	// �л� �⼮ ����
	public String[][] listAtt(String code) {
		return studentsdao.selectMemberAtt(code);
	}
	
	// �л� ���� ����
	public String[][] listSco(String code) {
		return studentsdao.selectMemberScore(code);
	}
	
	// ���� ����
	public void pictureIn(String pname, String code) throws FileNotFoundException {
		studentsdao.savePicture(pname, code);
	}
	
}
