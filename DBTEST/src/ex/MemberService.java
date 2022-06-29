package ex;
import java.util.List;

public class MemberService {
	private MemberDao memberDao;

	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// ����ϱ�
	public boolean regist(MemberVo vo) {
		if (memberDao.selectMember(vo.getNum()) == null) {
			memberDao.insertMember(vo);
			return true;
		}
		return false;
	}

	// ��ȸ
	public MemberVo read(int num) {
		return memberDao.selectMember(num);
	}

	// ��ü��ȸ
	public List<MemberVo> listAll() {
		return memberDao.selectMemberAll();
	}
	
	// ����
	public void edit(MemberVo vo) {
		memberDao.updateMember(vo);
	}
	
	// Ż��
	public void remove(int num) {
		memberDao.deleteMember(num);
	}

}
