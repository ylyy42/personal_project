package database.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class StudentsService {
	private StudentsDao studentsdao;
	
	public StudentsService(StudentsDao studentsdao) {
		this.studentsdao = studentsdao;
	}

	// ��ü��ȸ(�л� �̸�, �б�, �г⸸ ��������)
	public String[][] listAll() {
		return studentsdao.selectMemberAll();
	}
	
	// �л�������������
	public List<StudentsVo> infor(String name) {
		return studentsdao.selectMember(name);
	}
	
	// �л� ���� ����
	public String[][] listLec(String name) {
		return studentsdao.selectMemberLec(name);
	}
	
	// �л� �⼮ ����
	public String[][] listAtt(String name) {
		return studentsdao.selectMemberAtt(name);
	}
	
	// �л� ���� ����
	public String[][] listSco(String name) {
		return studentsdao.selectMemberScore(name);
	}
	
	// ���� ����
	public void pictureIn(String pname, String name) throws FileNotFoundException {
		studentsdao.savePicture(pname, name);
	}
	
}
