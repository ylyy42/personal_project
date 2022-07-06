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

	// 등록하기
	public boolean regist(ManagerVo vo) {
		managerDao.insertMember(vo);
		return true;
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
