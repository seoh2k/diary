package gdu.diary.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.DiaryService;
import gdu.diary.vo.Member;

@WebServlet("/auth/diary")
public class DiaryController extends HttpServlet {
	private DiaryService diaryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.diaryService = new DiaryService();
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("sessionMember")).getMemberNo();
		String targetYear = request.getParameter("targetYear"); // "2021" 문자열로 넘어간다(전처리 하지 않았다)
		String targetMonth = request.getParameter("targetMonth"); // 4월이면...3, 5월이면 ...4
		
		Map<String, Object> diaryMap = this.diaryService.getDiary(memberNo, targetYear, targetMonth);
		
		// setAttribute: 속성값을 변경시키는 메서드
		request.setAttribute("diaryMap", diaryMap); // jsp페이지로 값을 넘겨준다
		
		request.getRequestDispatcher("/WEB-INF/view/auth/diary.jsp").forward(request, response);
	}
}
