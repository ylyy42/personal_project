package awt;

import java.util.List;

public class ManagerService {
	private ManagerDao managerDao;

	public ManagerService(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	// ����ϱ�
	public boolean regist(ManagerVo vo) {
		if (managerDao.selectMember(vo.getNum()) == null) {
			managerDao.insertMember(vo);
			return true;
		}
		return false;
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
