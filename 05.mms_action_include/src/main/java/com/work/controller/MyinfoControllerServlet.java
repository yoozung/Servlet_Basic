package com.work.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.dto.Member;
import com.work.service.MemberService;

/**
 * Servlet implementation class MyinfoControllerServlet
 */
public class MyinfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 내 정보 조회*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존세션가져오기 
		HttpSession session = request.getSession(false);
		
		// 사용자검증 (세션 = null : 로그인되지 않은 것 -> 오류메세지)
		if (session == null) {
			request.setAttribute("message", "[오류] 내 정보 조회는 로그인 후 사용가능한 서비스입니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		// 세션에 있는 사용자의 아이디 가져오기
		String loginMemberId = (String)session.getAttribute("memberId");
		MemberService memberService = new MemberService();
		Member dto = memberService.getInfoToDto("loginMemberId");

		if (dto == null) {
			request.setAttribute("message", "[실패] 정보를 조회할 수 없습니다.");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		
		
		
		doGet(request, response);
		
		
		
		
	}
	
	

}
