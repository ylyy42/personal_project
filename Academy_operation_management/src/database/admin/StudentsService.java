package database.admin;

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
}
