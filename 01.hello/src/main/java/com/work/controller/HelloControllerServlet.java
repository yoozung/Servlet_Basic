package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloControllerServlet
 */
public class HelloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("1. 서블릿 메모리 로딩 수행 : 2차 변경");
	}
	
	public HelloControllerServlet() {
		System.out.println("2. 서블릿 객체 생성 수행 : 2차 변경");
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		사용자 초기화 코드 수행문 	
//	 	이닛메서드를 선택하고 만들면 부모로 물려받은게 와서 뭑 ㅏ잘못됨,, 
// 		ㄴ그래서 이닛메서드 자동완성하면 안되고 자동완성쓸 경우 init()으로 수정해주기
//	}
	
	public void init() throws ServletException {
		System.out.println("3. 서블릿 초기화 수행 : 2차 변경");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("5. 서블릿 자원해제 수행 : 2차 변경");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("4. Get 요청 서비스 수행");
		// dispatch
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("4. Post 요청 서비스 수행 : 2차 변경");
		// dispatch
		process(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	/* 두겟 두포스트로 들어오는거 여기로 넘길것임 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String HTTP_Method = request.getMethod();	//getMethod()은 사용자가 요청한게 겟인지 포스트인지 확인하는 메소드
		System.out.println("HTTP_Method: " + HTTP_Method);
		System.out.println(request.getRequestURI());	// /mms01/hi
		System.out.println(request.getRequestURL());	// http://localhost:8070/mms01/hi
	}
	
}



