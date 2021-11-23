package com.work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.dto.Member;

/**
 * 서블릿 3.x Annotation 설정
 */
//@WebServlet("/controller")
//@WebServlet(value = "/controller", loadOnStartup = 1)	// loadOnStartup은 이 서블릿을 자동으로 메모리에 올려주는거
//@WebServlet(urlPatterns = {"/list", "/detail"}, loadOnStartup = 1)
@WebServlet(urlPatterns = {"/controller"})
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList<Member> listMember;
	
	// 해당 어플리케이션에 대한 환경 설정 객체 : 해당 어플리케이션에 존재하는 모든 서블릿/jsp들이 공유가능한 객체, 서버가 중지시까지 사용가능한 범위  
	public ServletContext application;

	// init 메서드 재정의
	@Override
	public void init() throws ServletException {
		// 현재 서블릿이 속해있는 해당 웹어플리케이션 객체 가져오기 
		application = getServletContext();
		
		// loadOnStartup = 1 설정 : 서버 구동시에 해당 서블릿 자동으로 메모리 로딩시킴
		System.out.println("## 서버구동 application 컨텍스트이름 : " + application.getContextPath());
		application.setAttribute("CONTEXT_PATH", application.getContextPath());
		
		// ArrayList에 회원객체 3명만 등록
		listMember = new ArrayList<Member>();
		
		Member dto1 = new Member("user01", "password01",	"홍길동",	"010-1234-1111",	"user01@work.com",	"2017.05.05",	"G", 75000, null);	
		Member dto2 = new Member("user04",	"password04",	"김유신",	"010-1234-1114",	"user04@work.com",	"2017.05.08",	"S", 0,	"송중기");
		Member dto3 = new Member("user05",	"password05",	"유관순",	"010-1234-1115",	"user05@work.com",	"2017.05.09",	"A", 0, null);	

		listMember.add(dto1);
		listMember.add(dto2);
		listMember.add(dto3);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 요청시에 controller에 요청시에 action을 parameter로 전송 
		// url?action=list, url?action=detail&memberId=user01
		// controller?action=list, controller?action=detail&memberId=user01
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		
		// 요청에 따라 해당 요청을 처리하는 메서드 분리설계해서 dispatch
		switch(action) {
		case "list":
			list(request, response);
			break;
		case "detail":
			detail(request, response);	
			break;
		default:
			System.out.println("현재 지원되지 않는 요청 서비스입니다.");
		}
	}
	
	/** 회원정보 변경 저장 요청 서비스 */
	private void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberUpdate 회원정보변경 요청 처리");
		String memberId = request.getParameter("memberId");
		String memberIPw = request.getParameter("memberIPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String entryDate = request.getParameter("entryDate");
		String grade = request.getParameter("grade");
		//int mileage = 0;
		if (request.getParameter("mileage") != null && request.getParameter("mileage").trim().length() > 0) {
				int mileage = Integer.parseInt(request.getParameter("mileage"));
		}
		String manager = request.getParameter("manager");
		
		
	}
	
	/** 회원상세조회 요청 서비스 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter로 전달받은 회원의 아이디 정보가져오기
		String memberId = request.getParameter("memberId");
		System.out.println("memberId: " + memberId);
		
		for (Member dto : listMember) {
			if (dto.getMemberId().equals(memberId)) {
				// 응답위한 설정
				request.setAttribute("contentsTitle", "회원상세조회");
				request.setAttribute("dto", dto);
				// 응답페이지 이동
				request.getRequestDispatcher("memberDetail.jsp").forward(request, response);
				return;
			}
		}
		// 오류처리
		System.out.println("[오류] 해당 아이디가 존재하지 않음");
	}

	/** 전체회원조회 요청 서비스*/
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listMember", listMember);
		request.getRequestDispatcher("memberList.jsp").forward(request, response);
		
	}
	
	protected void process2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청URL을 이용해서 맨뒤에 있는 요청을 추출하기
		// request.getRequestURI() : http://localhost:8070/mms06/detail
		String URL = request.getRequestURL().toString();	
		
		// 하나의 FrontController 서블릿에 모든 요청 처리 : 실제 요청 action
		String action = URL.substring(URL.lastIndexOf("/") + 1); 	// list, detail
		System.out.println("action : " + action);

	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	
	protected void doGet2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request.getRequestURI() : "+ request.getRequestURI());
		System.out.println("/controller : " + request.getMethod());
		System.out.println("listMember.size() : " + listMember.size());
	
		// 회원상세조회요청시 전달받은 파라메타데이터 가져오기
		System.out.println("상세조회 회원아이디: " + request.getParameter("memberId"));
	
		// 응답위한 설정
		request.setAttribute("listMember", listMember);
		
		// memberList.jsp forward 이동
		request.getRequestDispatcher("memberList.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/controller : " + request.getMethod());

	}

}
