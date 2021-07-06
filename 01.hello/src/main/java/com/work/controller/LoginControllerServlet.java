package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginControllerServlet
 */
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 	## 서블릿 서비스 메서드 재정의 순서 
		
		0. 요청파악
		1. 요청객체에 대한 한글 인코딩 설정
		2. 요청데이터 추출 : 요청페이지 로그인요청페이지 login.jsp name="변수명"
		3. 요청데이터 검증
		4. Model 요청의뢰
		5. 6. 7. 
		  => 서블릿 코드 html 동적 작성 
		  => 응답을 위한 mine-type 및 한글인코딩 설정
		  => 응답을 위한 출력스트림 생성 
		  => 출력스트림을 이용해서 동적 "<html>" 응답페이지 전송
		  
		**(jsp 학습 후 진행)**
		5. Model 요청결과를 받아서 응답을 위한 설정
		6. 응답페이지 이동 : jsp
		7. 응답페이지 응답 결과 보여주기 : jsp
		  
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 요청"); // 0.
		request.setCharacterEncoding("utf-8"); // 1.
		String memberId = request.getParameter("memberId"); // 2. <input type="text" name="memberId" placeholder="아이디">
		String memberPw = request.getParameter("memberPw"); // 2. <input type="password" name="memberPw" placeholder="비밀번호">
		System.out.println(memberId + ", "+ memberPw);
	}

}
