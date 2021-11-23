package com.work.util;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * -- 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * -- 모든 메서드는 객체생성없이 사용가능 Class Method 선언(static method)
 * </pre>
 * 
 * @author 임경혜
 *
 */
public class Utility {
	
	/** 
	 * 테스트시에 테스트 항목을 출력하기 위한 메서드
	 * @param message 테스트 문자열
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
	/**
	 * 현재 날짜를 기본날짜형식 년도 4자리.월2자리.일2자리 형식의 문자열 변환 반환 메서드
	 * @return 기본 형식의 현자낼짜 문자열
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	};
	
	
	/**
	 * 아규먼트로 전달받은 날짜 형식의 현재날짜 변환 반환 메서드 
	 * @param pattern 날짜형식
	 * @return 날짜형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	/**
	 * <pre>
	 * 아규먼트로 전달받은 날짜 형식, 로케일 형식의 현재날짜 변환 반환 메서드
	 * 로케일 : java.util.Locale => FIELD 참고
	 * java.util.SimpleDateFormat 생성자 중복정의 => public SimpleDateFormat(String, Locale)
	 * 
	 * </pre>
	 * @see java.util.Locale
	 * @see java.util.SimpleDateFormat
	 * @param pattern  날짜형식  및 시간 형식
	 * @param locale 로케일형식
	 * @return  날짜 형식, 로케일 형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	public static String getSecureNumberString() {
		return getSecureNumberString(4);
	}
	
	public static String getSecureNumberString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			secureString.append(random.nextInt(10));
		}
		return secureString.toString();
	}

	/** 보안 영문 대문자 */
	public static String getSecureAlphabetString() {
		return getSecureAlphabetString(4);
	}
	
	public static String getSecureAlphabetString(int length) {
		return getSecureAlphabetString(length, true);
	}

	public static String getSecureAlphabetString(int length, boolean isUpper) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			if (isUpper) {
				secureString.append((char)(random.nextInt(26) + 'A')); // + 65
			} else {
				secureString.append((char)(random.nextInt(26) + 'a'));	// + 97
			}
		}
		return secureString.toString();
	}

	public static String getSecureAlphabetString(int length, boolean isUpper, boolean isMixed) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			if (isMixed) {
				if(random.nextBoolean()) {
					if (isUpper) {
						secureString.append((char)(random.nextInt(26) + 'A')); 
					} else {
						secureString.append((char)(random.nextInt(26) + 'a'));	
					}
				} else {
					secureString.append(random.nextInt(10));
				}
			} else {
				if (isUpper) {
					secureString.append((char)(random.nextInt(26) + 'A')); 
				} else {
					secureString.append((char)(random.nextInt(26) + 'a'));	
				}
			}
		}
		return secureString.toString();
	}
	
	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(45) + 1; // 0 ~ 44 , 46:0~45, 45:0~44+1 => 1~45
	}
	
	/**
	 * 서블릿 GET 요청시 전달 데이터에 대한 한글 인코딩 UTF-8 변환 
	 * @param data 
	 * @return 변환 문자열
	 */
	public static String toKor(String data) {
		try {
			return new String(data.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("[오류] 지원되지 않는 인코딩입니다. : " + e.getMessage());
		}
		return data;
	}
}









