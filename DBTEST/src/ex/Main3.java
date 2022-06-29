package ex;

import java.util.Date;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {

		// MemberDao memberDao = new MemberDao();
		MemberService memberService = new MemberService(new MemberDao());

		// C(insert)
		MemberVo vo1 = new MemberVo(1, "test11", "1234", "nick11");
		MemberVo vo2 = new MemberVo(2, "test22", "1234", "nick22");
		MemberVo vo3 = new MemberVo(3, "test33", "1234", "nick33");

		memberService.regist(vo1);
		memberService.regist(vo2);
		memberService.regist(vo3);
		System.out.println("저장완료");

		// R(select)
		List<MemberVo> ls = memberService.listAll();
		for (MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회 완료!");

		MemberVo vo = null;
		vo = memberService.read(1);
		System.out.println(vo);

		vo = memberService.read(4);
		System.out.println(vo);
		System.out.println("조회완료");

		// U(update)
		vo = memberService.read(1);
		System.out.println(vo);

		if (vo != null) {
			vo.setMemberPw("4321");
			vo.setNickName("1nick");
			memberService.edit(vo);
		}
		vo = memberService.read(1);
		System.out.println(vo);
		System.out.println("수정완료");

		// D(delete)
		memberService.remove(2);
		ls = memberService.listAll();
		for (MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회 완료!");

	}
}
