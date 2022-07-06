package Login;

import java.util.List;

public class ManagerService {
	private ManagerDao managerDao;

	public ManagerService(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	public boolean check(ManagerVo vo) {
		if(managerDao.check(vo) == false) {
			return false;
		}
		return true;
	}

	// ����ϱ�
	public boolean regist(ManagerVo vo) {
		managerDao.insertMember(vo);
		return true;
	}

	// �α���
	public boolean login(ManagerVo vo) {
		if (managerDao.list(vo) == true) {
			return true;
		}
		return false;
	}

	// ��ȸ
	public ManagerVo read(int num) {
		return managerDao.selectMember(num);
	}

	// ��ü��ȸ
	public List<ManagerVo> listAll() {
		return managerDao.selectMemberAll();
	}

	// ����
	public void edit(ManagerVo vo) {
		managerDao.updateMember(vo);
	}

	// Ż��
	public void remove(int num) {
		managerDao.deleteMember(num);
	}

}
