package com.work.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LogoutControllerServlet
 */
public class LogoutControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/** 로그아웃 요청*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그아웃요청");
		
		
		// 기존 세션객체 가져오기, 만약 세션이 없으면 null
		// jsp 페이지를 통해서 요청이 들어오면 무조건 자동으로 세션객체 생성됨 : 주의 
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			// 세션객체가 존재하면 => jsp 페이지를 통해서 요청이 들어오면 무조건 자동으로 세션객체 생성됨 : 주의 
			
			// 로그인시에 설정해놓은 상태정보가 있는지 체킹해서 : 아이디랑 등급 설정해둠
			if (session.getAttribute("memberId") != null) {
				// 상태정보가 있으면 해당 상태정보를 삭제
				session.removeAttribute("memberId"); // 혹시라도 세션객체가 삭제되지 않아도 설정된 상태정보는 삭제 => 최소 보안방어
			}
			if (session.getAttribute("grade") != null) {
				// 상태정보가 있으면 해당 상태정보를 삭제
				session.removeAttribute("grade");
			}
			
			// 세션객체를 삭제 (상태정보삭제해도 수행이 안 될 수도 있어서 세션까지 삭제)
			session.invalidate();
			
			// 로그아웃 응답페이지 이동 
			response.sendRedirect("index.jsp");
		
		} else {
			// 세션객체가 존재하지 않거나 상태정보가 없으면 오류페이지 응답처리
			request.setAttribute("message", "[오류] 로그아웃요청은 로그인 후 사용가능한 서비스입니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

}
