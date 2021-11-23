package com.work.dto;

import java.io.Serializable;

/**
 * <pre>
 * 회원 도메인 클래스 
 * </pre>
 * 
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class Member implements Serializable {
	/** 아이디, 식별키 */
	private String userID;
	
	/** 비밀번호, 필수 */
	private String userPW;
	
	/** 이름, 필수 */
	private String userName;

	public Member(String userID, String userPW, String userName) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [userID=" + userID + "]";
	}

}
