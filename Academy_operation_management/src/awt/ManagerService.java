package awt;

import java.util.List;

public class ManagerService {
	private ManagerDao managerDao;

	public ManagerService(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	// 등록하기
	public boolean regist(ManagerVo vo) {
		if (managerDao.selectMember(vo.getNum()) == null) {
			managerDao.insertMember(vo);
			return true;
		}
		return false;
	}

	// 로그인
	public boolean login(ManagerVo vo) {
		if (managerDao.list(vo) == true) {
			return true;
		}
		return false;
	}

	// 조회
	public ManagerVo read(int num) {
		return managerDao.selectMember(num);
	}

	// 전체조회
	public List<ManagerVo> listAll() {
		return managerDao.selectMemberAll();
	}

	// 수정
	public void edit(ManagerVo vo) {
		managerDao.updateMember(vo);
	}

	// 탈퇴
	public void remove(int num) {
		managerDao.deleteMember(num);
	}

}
