package com.work.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.service.MemberService;

/**
 * Servlet implementation class LoginControllerServlet
 */
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	/**
	 	## jsp 응답페이지 이동하기
	 	
	 	## 서블릿 서비스 메서드 재정의 순서 
		0. 요청파악
		1. 요청객체에 대한 한글 인코딩 설정
		2. 요청데이터 추출 : 요청페이지 로그인요청페이지 login.jsp name="변수명"
		3. 요청데이터 검증
		4. Model 요청의뢰
		5. Model 요청결과를 받아서 응답을 위한 설정
		6. 응답페이지 이동 : jsp
		7. 응답페이지 응답 결과 보여주기 : jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 요청 : " + request.getRequestURL());
		// request.setCharacterEncoding("utf-8");  로그인할때 한글 입력하는거 없으니까 없어도 됨

		// 요청데이터 추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		// 데이터 검증
		if (memberId == null || memberId.trim().length() == 0 || memberPw == null || memberPw.trim().length() == 0) {
			request.setAttribute("message", "로그인 실패 : 로그인 정보를 올바르게 입력하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		// 공백제거 
		memberId = memberId.trim();
		memberPw = memberPw.trim();
		
		//멤버서비스객체만들어서 멤버서비스에게 검증된 아이디비번 줄테니 등급줘라
		MemberService memberService = new MemberService();
		String grade = memberService.login(memberId, memberPw);

		if (grade != null) {
			// 세션 로그인처리
			HttpSession session = request.getSession(); // 새로운 세션 만든거.. 겟세션은 세션있으면 있는거 쓰고 없으면 만들어주는거
			
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);
			
			response.sendRedirect("main.jsp");

		} else {
			request.setAttribute("message", "로그인 실패 : 로그인 정보가 올바르지 않습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	
	//doPost2
	protected void doPost2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 요청"); // 0.
		request.setCharacterEncoding("utf-8"); // 1.

		String memberId = request.getParameter("memberId"); // 2. <input type="text" name="memberId" placeholder="아이디">
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberId + ", " + memberPw); // parameter key가 존재하지 않으면 null

		// 데이터가 올바르지 않은 경우 처리
		if (memberId == null || memberId.trim().length() == 0 || memberPw == null || memberPw.trim().length() == 0) {

			// 5. Model 요청결과를 받아서 응답을 위한 설정 (모델 아직 안배워서 아래방법으로)
			// 요청객체에 응답메세지 설정
			request.setAttribute("message", "로그인 실패 : 로그인 정보를 올바르게 입력해주세요.");

			// result.jsp 페이지로 forward 이동
			RequestDispatcher nextView = request.getRequestDispatcher("result.jsp");
			nextView.forward(request, response);
			return; // 요청 서비스 완료됨
		}

		// java.lang.IllegalStateException: 응답이 이미 커밋된 후에는 forward할 수 없습니다.
		// 로그인 데이터 검증완료 => 로그인 모델 요청 처리 진행
		request.setAttribute("message", " 로그인 성공 : " + memberId);

		// result.jsp 페이지로 forward 이동
		RequestDispatcher nextView = request.getRequestDispatcher("main.jsp");
		nextView.forward(request, response);

	}
	
	
	
	/**
 	## 서블릿 서비스 메서드 재정의 순서 
	
	0. 요청파악
	1. 요청객체에 대한 한글 인코딩 설정
	2. 요청데이터 추출 : 요청페이지 로그인요청페이지 (login.jsp name="변수명")
	3. 요청데이터 검증
	4. Model 요청의뢰
	5. 6. 7. 
	  => 서블릿 코드 html 동적 작성 
	  => 응답을 위한 mine-type 및 한글인코딩 설정
	  => 응답을 위한 출력스트림 생성 
	  => 출력스트림을 이용해서 동적 "<html>" 응답페이지 전송
 */
	protected void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 요청"); // 0.
		request.setCharacterEncoding("utf-8"); // 1.
		
		String memberId = request.getParameter("memberId"); // 2. <input type="text" name="memberId" placeholder="아이디">
		String memberPw = request.getParameter("memberPw"); 
		System.out.println(memberId + ", "+ memberPw);	// parameter key가 존재하지 않으면 null
		
		// 5. 6. 7
		// 응답을 위한 mine-type 및 한글인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 응답을 위한 출력스트림 생성 
		PrintWriter out = response.getWriter();
		
		// 출력스트림을 이용해서 동적 "<html>" 응답페이지 전송
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<title>로그인결과페이지</title>");
		out.println("</head>");
		out.println("<body>");
		
		
		// 3. 요청데이터 검증 : 필수 입력항목 (공백확인)
		if (memberId != null && memberId.trim().length() > 0 &&
				memberPw != null && memberPw.trim().length() > 0) {	// valid
			
			memberId = memberId.trim();
			memberPw = memberId.trim();
			
			System.out.println("데이터 검증 성공 : 아이디비번 입력");
			
			out.println("<h3>" + memberId + " 로그인 성공</h3>");
			
			
		} else {
			System.out.println("데이터 검증 실패 : 아이디비번 미입력");
			out.println("<h3>로그인 실패 : 로그인 정보를 올바르게 입력해주세요." + memberId + "</h3>");
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();	// 자원해제
	}

}
