package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.service.MemberService;

/**
 * Servlet implementation class MyinfoControllerServlet
 */
public class MyinfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
//		String memberPw = request.getParameter("memberPw");
//		String name = request.getParameter("name");
//		String mobile = request.getParameter("mobile");
//		String email = request.getParameter("email");
//		String entryDate = request.getParameter("entryDate");
//		String grade = request.getParameter("grade");
//		String mileage = request.getParameter("mileage");
//		String manager = request.getParameter("manager");
		
		
		MemberService memberService = new MemberService();
		String info = memberService.selectOne(memberId);

		
		
		
		
		
		doGet(request, response);
		
		
		
		
	}
	
	

}
