package java_09_3_ex1_userManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java_09_1_ex1_studentManager.Student;

public class MemberEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int menuNo;
        List<Member> list = new ArrayList<Member>(100);
        do {
            System.out.println("===== 회원관리 및 로그인 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 삭제");
            System.out.println("3. 회원 조회");
            System.out.println("4. 로그인");
            System.out.println("5. 로그아웃");
            System.out.println("6. 종료");
            String menuNoString;
            while (true) {
              System.out.print("메뉴를 선택하세요:");
              menuNoString = scanner.nextLine();
              try {
            	  menuNo = Integer.parseInt(menuNoString);
                  break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
              } catch (NumberFormatException e) {
                  System.out.println("1부터 6사이의 숫자를 입력하세요.");
              }
            }
            switch (menuNo) {
                case 1 :
                	System.out.println("-----------");
                    System.out.println("회원 추가");
                    System.out.println("-----------");
                    String id;
                    boolean memberExists = false;
                    do {
                        System.out.print("ID: ");
                        id = scanner.nextLine();
                        memberExists = false;
                        for (Member i : list) {
                            if (i.getId().equals(id)) {  
                                System.out.println("아이디가 이미 존재합니다.");
                                memberExists = true;
                                break;
                            } 
                        }
                        if (memberExists) {
                            continue; // 다시 아이디 입력 받음
                        }
                        if (validatePassword(id)) {
                            System.out.println("아이디 유효성 검사 통과");
                        } else {
                            System.out.println("아이디 유효성 검사 실패");
                            continue;
                        }         
                        break; // 아이디 유효성 검사 통과 시 반복문 종료
                    } while (true);
                    String password;
                    do {
                        System.out.print("PW: ");
                        password = scanner.nextLine();
                        if (validatePassword(password)) {
                            System.out.println("비밀번호 유효성 검사 통과");
                        } else {
                            System.out.println("비밀번호 유효성 검사 실패");
                            continue;
                        }                                      
                        break; // 비밀번호 유효성 검사 통과 시 반복문 종료
                    } while (true);                              
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    String email;
                    do {
                        System.out.print("E-mail: ");
                        email = scanner.nextLine();
                        if (validateEmail(email)) {
                            System.out.println("이메일 유효성 검사 통과");
                        } else {
                            System.out.println("이메일 유효성 검사 실패");
                            continue;
                        }                                
                        break; // 이메일 유효성 검사 통과 시 반복문 종료
                    } while (true);
                    System.out.print("전화번호: ");
                    String phone = scanner.nextLine();                  
                    Member member = new Member(id, password, name, email, phone);
                    list.add(member);
                    System.out.println("회원가입 성공!");
                    break;
                case 2 :
                	if (list.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다.");
                        break;
                    } else {
                        System.out.println("-----------");
                        System.out.println("회원 삭제");
                        System.out.println("-----------");
                        boolean deleteExists = true;
                        System.out.print("ID: ");
                        id = scanner.nextLine();
                        for (Member i : list) {
                          if (!i.getId().equals(id)) {         
                          	System.out.println("해당 아이디의회원이 존재하지 않습니다.");
                          	deleteExists = false;
                          	break;
                          } else {
                        	  list.remove(i);
                        	  System.out.println("회원을 삭제했습니다.");
                        	  break;
                          }                          
                      }          	
                        break;
                    }  
                case 3 :
                	if (list.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다.");
                        break;
                    } else {
                        System.out.println("-----------");
                        System.out.println("회원 조회");
                        System.out.println("-----------");
                        for (Member i: list) {
                        	System.out.println(i.getName()+ "    " + i.getId() + "     " + i.getEmail() + "     " + i.getPhone());
                        }                        	
                        break;
                    }                    
                case 4:
                	if (list.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다.");
                        break;
                    } else {
                	String loginId;
                	String loginPassword;
                    do {
                        System.out.print("ID: ");
                        loginId = scanner.nextLine();
                        memberExists = false;
                        for (Member i : list) {
                            if (!i.getId().equals(loginId)) {  
                                System.out.println("존재하지 않는 아이디입니다.");
                                continue;
                            } else {                          	
                            	System.out.print("PW: ");
                            	loginPassword = scanner.nextLine();
                            	i.login(loginId, loginPassword);
	                            }                            
	                        }                             
	                        break; 
	                    } while (true);

                    }
                	
                case 5:
                case 6:
                    System.out.println("프로그램 종료");
                    break;
                default :
                    System.out.println("1부터 6사이의 숫자를 입력하세요.");
                    break;
            }
        } while (menuNo !=6);

	}
	// 아이디 유효성 검사 정규표현식
	public static boolean validateId(String id) {
        String regex = "^[a-zA-Z0-9]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    // 비밀번호 유효성 검사 정규표현식
    public static boolean validatePassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    // 이메일 유효성 검사 정규표현식
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
