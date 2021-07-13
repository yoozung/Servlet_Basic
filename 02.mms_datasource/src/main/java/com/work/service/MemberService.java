package com.work.service;

import java.util.Map;

import com.work.dao.MemberDao;
import com.work.util.Utility;

public class MemberService {
	private MemberDao memberDao = MemberDao.getInstance();
	
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
	
	public String login(Map<String, String> dtoMap1) {
		System.out.println("service login()" + dtoMap1);
		
		
		return null;
	}
}
