package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.dto.Member;
import com.work.service.MemberService;

/**
 * 회원관리 시스템의 모든 요청을 제어하기 위한 Front Controller
 * -- 요청파악 : action=xxx
 */
@WebServlet(urlPatterns = {"/controller"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		switch (action) {
		case "join":
			join(request, response); 	// 회원가입저장 요청
			break;
		case "login":
			login(request, response); 	// 로그인 요청
			break;
		case "logout":
			logout(request, response); 	// 로그아웃 요청
			break;
		case "myInfo":
			myInfo(request, response); 	// 내정보조회 요청
			break;
		case "myInfoUpdate":
			myInfoUpdate(request, response); 	// 내정보변경 요청
			break;
		case "memberList":
			memberList(request, response); 	// 관리자 : 전체회원조회 요청
			break;
		case "memberDetail":
			memberDetail(request, response); 	// 관리자: 회원상세조회 요청
			break;
		case "memberUpdate":
			memberUpdate(request, response); 	// 관리자: 회원정보변경 요청
			break;

		default:
			System.out.println("[오류] 지원되지 않는 요청 서비스입니다.");
			break;
		}
	}

	/** 회원가입 요청 */
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("join 회원가입요청");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		Map<String, String> dtoMap = new HashMap<String, String>();
		dtoMap.put("memberId", memberId);
		dtoMap.put("memberPw", memberPw);
		dtoMap.put("name", name);
		dtoMap.put("mobile", mobile);
		dtoMap.put("email", email);
		
		System.out.println(dtoMap);
		
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (memberId == null || memberId.trim().length() == 0 || memberId.trim().length() > 30) {
			errorList.add("아이디는 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		if (memberPw == null || memberPw.trim().length() == 0 || memberPw.trim().length() > 20) {
			errorList.add("비밀번호는 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (name == null || name.trim().length() == 0 || name.trim().length() > 20) {
			errorList.add("이름은 필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (mobile == null || mobile.trim().length() == 0 || mobile.trim().length() > 13) {
			errorList.add("휴대폰은 필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
		}
		if (email == null || email.trim().length() == 0 || email.trim().length() > 30) {
			errorList.add("이메일은 필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		
		HashMap<String, String> errorMap = new HashMap<String, String>();
		
		if (memberId == null || memberId.trim().length() == 0 || memberId.trim().length() > 30) {
			errorMap.put("memberId", "필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}
		if (memberPw == null || memberPw.trim().length() == 0 || memberPw.trim().length() > 20) {
			errorMap.put("memberPw", "필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (name == null || name.trim().length() == 0 || name.trim().length() > 20) {
			errorMap.put("name", "필수입력항목이며 20자리 이내로 입력하시기 바랍니다.");
		}
		if (mobile == null || mobile.trim().length() == 0 || mobile.trim().length() > 13) {
			errorMap.put("mobile", "필수입력항목이며 13자리 이내로 입력하시기 바랍니다.");
		}
		if (email == null || email.trim().length() == 0 || email.trim().length() > 30) {
			errorMap.put("email", "필수입력항목이며 30자리 이내로 입력하시기 바랍니다.");
		}		
		
		if (!errorList.isEmpty()) { //if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			request.setAttribute("errorMap", errorMap);
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		MemberService memberService = new MemberService();
		int result = memberService.addMember(dtoMap);
		
		if (result == 1) {	
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert(\"회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.\");");
			out.println("location.href=\"login.jsp\";");
			out.println("</script>");
			out.close();
			
		} else { 
			errorList.add("회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			errorMap.put("result", "회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			request.setAttribute("message", "회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

//	ajax 회원가입
	protected void sign_up(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("join 회원가입요청");
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		
		Map<String, String> dtoMap = new HashMap<String, String>();
		dtoMap.put("userID", userID);
		dtoMap.put("userPW", userPW);
		dtoMap.put("userName", userName);
		
		System.out.println(dtoMap);
		
		MemberService memberService = new MemberService();
		int result = memberService.addMember(dtoMap);
		
		if (result == 1) {	
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert(\"회원가입이 정상처리되었습니다. 로그인 후 회원전용서비스를 이용하시기 바랍니다.\");");
			out.println("location.href=\"login.jsp\";");
			out.println("</script>");
			out.close();
			
		} else { 
			request.setAttribute("message", "회원가입이 정상 처리되지 않았습니다. 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	
	/** 로그인 요청 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login 로그인 요청"); 

		String memberId = request.getParameter("memberId"); 
		String memberPw = request.getParameter("memberPw");
		
		if (memberId == null || memberId.trim().length() == 0 ||
				memberPw == null || memberPw.trim().length() == 0) {
			request.setAttribute("message", "로그인 실패 : 로그인 정보를 올바르게 입력하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return; 
		} 
		
		memberId = memberId.trim();
		memberPw = memberPw.trim();
		
		MemberService memberService = new MemberService();
		String grade = memberService.login(memberId, memberPw);
		
		if (grade != null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);
			response.sendRedirect("main.jsp");	
		} else {
			request.setAttribute("message", "로그인 실패 : 로그인 정보가 올바르지 않습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	/** 로그아웃 요청 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout 로그아웃요청");
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			if (session.getAttribute("memberId") != null) {
				session.removeAttribute("memberId"); 
			}
			
			if (session.getAttribute("grade") != null) {
				session.removeAttribute("grade");
			}
			
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("message", "[오류] 로그아웃 요청은 로그인 후 사용가능한 서비스 입니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	
	/** 내정보조회 요청 */
	protected void myInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myInfo 내정보조회");
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
			request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		String loginMemberId = (String)session.getAttribute("memberId");
		MemberService memberService = new MemberService();
		
		Member dto = memberService.getMemberToDto(loginMemberId);
		HashMap<String, Object> dtoMap = memberService.memberServiceToMap(loginMemberId);
		
		if (dto == null) {
			request.setAttribute("message", "[실패] 내정보 조회를 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		if (dtoMap == null) {
			request.setAttribute("message", "[실패] 내정보 조회를 다시 확인하시기 바랍니다.");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("dtoMap", dtoMap);
		request.getRequestDispatcher("myInfo.jsp").forward(request, response);
	}
	
	/** 내정보변경 요청 */
	protected void myInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("myInfoUpdate 내정보 변경 저장");
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("grade") == null) {
			request.setAttribute("message", "[오류] 회원전용 서비스입니다. 로그인 후 이용하시기 바랍니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		}
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (!isRequired(memberId) || !isRequired(memberPw) || !isRequired(name) ||
				!isRequired(mobile) || !isRequired(email)) {
			out.println("<script type='text/javascript'>");
			out.println("alert('[내정보변경저장 실패] 내정보 변경 필수 입력항목을 모두 입력하시기 바랍니다.');");
			out.println("location.href='controller?action=myInfo'");
			out.println("</script");
			out.close();
			return;
		}
		
		MemberService memberService = new MemberService();
		// 회원 내정보 변경 저장
		//int result = memberService.setMember(new Member(memberId, memberPw, name, mobile, email));
		int result = memberService.setMember(memberId, memberPw, name, mobile, email);
		System.out.println("내정보변경저장 result: " + result);
		
		if (result == 1) {
			System.out.println("내정보변경저장 result == 1");
			out.println("<script type='text/javascript'>");
			out.println("alert('[내정보변경 성공] 내정보 변경이 완료되었습니다.');");
			out.println("location.href='main.jsp';");
			out.println("</script");
			out.close();
		} else {
			System.out.println("내정보변경저장 result == 0");
			out.println("<script type='text/javascript'>");
			out.println("alert('[내정보변경저장 실패] 내정보 변경 저장시 문제가 발생했습니다. 다시 확인하시기 바랍니다.');");
			out.println("location.href='main.jsp';");
			out.println("</script");
			out.close();
		}
	}	
	
	/* 사용자 인증 메서드 */
	public boolean isRequired(String data) {
		if (data != null && data.trim().length() > 0) {
			return true;
		}
		return false;
	}

	
	/* 관리자 요청 -------------------------------------------------*/
	/** 전체회원조회 요청 */
	protected void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	
	
	/** 회원상세조회 요청 */
	protected void memberDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	

	/** 회원정보변경 요청 */
	protected void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
