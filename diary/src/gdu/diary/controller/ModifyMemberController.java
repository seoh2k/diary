package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;

@WebServlet("/auth/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원정보 수정 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션값 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("sessionMember");

		//forward
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyMember.jsp").forward(request, response);
	}
	
	// 수정 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberService = new MemberService();
		
		// 입력 폼에서 받은 memberPw 수집
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 전처리: 멤버 vo 객체에 저장
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw); // 입력한 패스워드 추가
		
		// servic에서 modify메서드 호출
		this.memberService.modifyMemberPw(member);
		
		// 재요청
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}

}
