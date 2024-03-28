package java_09_3_ex1_userManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private boolean login = false;
	Member(String id, String password, String name, String email, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public String getId() {return id;}
	public String getPW() {return password;}
	public String getName() {return name;}
	public String getEmail() {return email;}
	public String getPhone() {return phone;}

	public boolean isLoggedIn() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public void login(String id, String password) {
		if (this.id.equals(id) && this.password.equals(password)) {
			if (isLoggedIn()) {
				System.out.println("이미 로그인되었습니다.");
			} else {				
				setLogin(true);
				System.out.println("로그인 성공!");
			}
		} else {
			System.out.println("로그인 실패...");
		}
	}
	public void logOut() {
		if (!isLoggedIn()) {
			System.out.println("이미 로그아웃되었습니다.");
		} else {				
			setLogin(false);
			System.out.println("로그아웃 성공!");
		}
	}
	
}
