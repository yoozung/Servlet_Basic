package com.work.service;

import java.util.Map;

import com.work.dao.MemberDao;
import com.work.dto.Member;
import com.work.util.Utility;

public class MemberService {
	private MemberDao memberDao = MemberDao.getInstance();
	
	/** 회원가입 서비스 */
	public int addMember(Map<String, String> dtoMap) {
		System.out.println("service addMember()" + dtoMap);
		
		// 사용자 입력한 가입정보(아이디, 비밀번호, 이름, 휴대폰, 이메일) + 서비스에서 속성 추가(가입일, 등급, 마일리지?) 
		dtoMap.put("entryDate", Utility.getCurrentDate());
		dtoMap.put("grade", "G");
		dtoMap.put("mileage", String.valueOf(5000));
		
		// 반환값이 int니까 int로 담기
		int result = memberDao.insertMember(dtoMap);
		System.out.println("addMember result: " + result);
		return result;
	}
	
	/** 로그인 서비스 */
	public String login(String memberId, String memberPw) {
		// 로그인 성공한 회원의 등급 반환 : 바로 return
		return memberDao.login(memberId, memberPw);
		
		// 로그인 성공한 회원의 등급이 "G" 인 경우에 별도의 서비스를 진행 
		
		
	}

	/** 내 정보 조회 */
	public Member getInfoToDto(String string) {
		
		return null;
	}
	

}
