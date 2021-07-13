package com.work.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * 모든 클래스에서 사용하기 위한 공통 메서드 구현 클래스
 * 모든 메서드는 객체생성 없이 사용가능하도록 Class Method 선언 (static method로 선언하란 말)
 * </pre>
 * 
 * @author ParkYuJung
 *
 */
public class Utility {
	
	public static void main1(String[] args) {
		
		// TODO 1 : 아규먼트로 받은 정수형 숫자를 천단위마다 컴마표기 문자열 반환 메서드
		print1("숫자형식");
		int mileage = 1234567;
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println(numberFormat.format(mileage));
		
		
		// TODO 2 : 아규먼트로 받은 정수형 숫자, 로케일을 받아서  
		//			화폐기호 및 천단위마다 컴마표기 문자열 반환 메서드
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance();
		System.out.println(numberFormat2.format(mileage));
		
	}
	// TODO 5: 보안문자 발급 메서드 : 기본으로 4자리 숫자형식의 문자열 반환 메서드
	public static String getSecureNumberString() {
//		Random random = new Random((long)(Math.random() * System.nanoTime()));
//		StringBuilder secureString = new StringBuilder();
//		
//		for ( int index = 0; index < 4; index++) {
//		secureString.append(random.nextInt(10));
//		}
//		return secureString.toString();
//	
	return getSecureNumberString(4);
	}
	
	public static String getSecureNumberString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		for ( int index = 0; index < length; index++) {
			secureString.append(random.nextInt(10));
		}	return secureString.toString();
	}
	
	/** 보안 영문 대문자 */
	public static String getSecureAlphabetString() {
		return getSecureAlphabetString(4);
	}
	
	public static String getSecureAlphabetString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for ( int index = 0; index < length; index++) {
			secureString.append((char)(random.nextInt(26) + 65)); //소문자는 97 대문자는 65
		} return secureString.toString();
	}
	
	public static int getLottoNo() {
	Random random = new Random((long)(Math.random() * System.nanoTime()));
	return random.nextInt(45) + 1;  // 0~44
			}
	
	public static void print1(String message) {
		System.out.println("\n### " + message);
	}
	
	public static void main(String[] args) {
		
//		System.out.println("현재날짜");
//		print1("현재날짜");
//		System.out.println(Utility.getCurrentDate());
//		System.out.println(Utility.getCurrentDate("MM-dd-yyyy"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.US));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.CHINA));
//		System.out.println(Utility.getCurrentDate("HH:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm", Locale.US));
//		
//		print1("숫자형식");
//		int mileage = 1234567;
//		NumberFormat numberFormat = NumberFormat.getInstance();
//		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance();
//		NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance(Locale.US);
//		
//		System.out.println(numberFormat.format(mileage));
//		System.out.println(numberFormat2.format(mileage));
//		System.out.println(numberFormat3.format(mileage));
		
		print1("미션#1");
		print1("임시발급숫자");
		System.out.println(Utility.getSecureAlphabetString(4));
		System.out.println(Utility.getSecureAlphabetString(6));
		System.out.println(Utility.getSecureAlphabetString(10));
	}
	
	/** 
	 * 테스트시에 테스트 항목을 출력하기 위한 메서드
	 * @param message 테스트 문자열
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
	/**
	 * <pre>
	 * 현재날짜 기본형식의 문자열로 변환하는 메서드
	 * -- 기본형식 : 년도4자리-월2자리-일2자리
	 * </pre>
	 * @return 현재날짜 기본형식 문자열
	 */
	public static String getCurrentDate() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date today = new Date();
//		return dateFormat.format(today);
		// 위에꺼 한줄로하면
		return getCurrentDate("yyyy-MM-dd");
	}
	
	/**
	 * 아규먼트로 전달받은 날짜 형식의 현재날짜 변환 반환 메서드
	 * @param pattern 날짜형식
	 * @return 날짜형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//		Date today = new Date();
//		return dateFormat.format(today);
		// 위에꺼 한줄로하면
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	/**
	 * <pre>
	 * 아규먼트로 전달받은 날짜 형식, 로케일 형식의 현재날짜 변환 반환 메서드
	 * 로케일 : java.util.Locale => FIELD 참고
	 * java.util.SimpleDateFormat 생성자 중복정의 => public SimpleDateFormat(String, Locale)
	 * </pre>
	 * 
	 * @see java.util.Locale
	 * @see java.util.SimpleDateFormat
	 * @param pattern  날짜형식  및 시간 형식
	 * @param locale 로케일형식
	 * @return  날짜 형식, 로케일 형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
//		Date today = new Date();
//		return dateFormat.format(today);
		// 위에꺼 한줄로하면
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * 유틸리티 테스트 메서드
	 * @param args
	 */
//	public static void main(String[] args) {
//		System.out.println(getCurruntDate()); // same class 호출일때만 이렇게 가능
//		System.out.println(Utility.getCurruntDate()); // other class 호출
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd")); 
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd hh:ss")); 
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd [a] hh:ss")); 
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd [a] hh:ss", Locale.US)); 
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd [a] hh:ss", Locale.JAPAN)); 
//		System.out.println(Utility.getCurruntDate("yyyy/MM/dd [a] hh:ss", Locale.CHINA)); 
//	}
}
