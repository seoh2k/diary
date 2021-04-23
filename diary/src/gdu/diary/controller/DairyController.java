package gdu.diary.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.DiaryService;

@WebServlet("/auth/diary")
public class DairyController extends HttpServlet {
	private DiaryService diaryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.diaryService = new DiaryService();
		String targetYear = request.getParameter("targetYear"); // "2021" 문자열로 넘어간다(전처리 하지 않았다)
		String targetMonth = request.getParameter("targetMonth"); // "4", ... null
		
		Map<String, Object> diaryMap = this.diaryService.getDiary(targetYear, targetMonth);
		
		// setAttribute: 속성값을 변경시키는 메서드
		request.setAttribute("diaryMap", diaryMap); // jsp페이지로 값을 넘겨준다
		
		
		request.getRequestDispatcher("/WEB-INF/view/auth/diary.jsp").forward(request, response);
	}
}
