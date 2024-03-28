package java_09_2_ex1_accountManager;

import java.util.*;

import java_09_1_ex1_studentManager.Student;

public class AccountManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int menuNo;
        Account[] list = new Account[100];
        int accountNo = 0;
        
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. 계좌생성 | 2: 계좌목록 | 3: 예금 | 4: 출금 | 5: 종료");
            System.out.println("-----------------------------------------------------------");
            String menuNoString;
            while (true) {
                System.out.print("선택>");
                menuNoString = scanner.nextLine();
                try {
              	  menuNo = Integer.parseInt(menuNoString);
                    break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                } catch (NumberFormatException e) {
                    System.out.println("1부터 5사이의 숫자를 입력하세요.");
                }
              }
            switch (menuNo) {
                case 1 :
                	System.out.println("-----------");
                    System.out.println("계좌생성");
                    System.out.println("-----------");
                    System.out.print("계좌번호: ");
                    String key = scanner.nextLine();
                    boolean accountExists = false;
                    if (list.length != 0) {
                    	 for (int i = 0; i < list.length; i++) {
                         	if (list[i] != null) {
                         		if (list[i].getKey().equals(key)) {         
                         			System.out.println("계좌가 이미 존재합니다.");
                         			accountExists = true;
                         			break;
                            	} 
                         	}
                    	 }
                    }
                    if (accountExists) {
                        break; // 반복문의 처음으로 돌아감
                    } 
                    System.out.print("계좌주: ");
                    String name = scanner.nextLine();
                    String numberString;
                    int number = 0;
                    while (true) {
                        System.out.print("초기입금액: ");
                        numberString = scanner.nextLine();
                        try {
                            number = Integer.parseInt(numberString);
                            break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력하세요.");
                        }
                    }
                    list[accountNo] = new Account(key, name, number);
                    accountNo += 1;                    
                    System.out.println("계좌가 생성 됐습니다.");
                    break;
                case 2 :
                    if (list.length == 0) {
                        System.out.println("계좌를 생성하세요.");
                        break;
                    } else {
                        System.out.println("-----------");
                        System.out.println("계좌목록");
                        System.out.println("-----------");
                        for (int i = 0; i < list.length; i++) {
                        	if (list[i] != null) {
                        	System.out.println(list[i].getKey()+ "    " + list[i].getName() + "     " + list[i].getNumber());
                        	}
                        }
                        break;
                    }
                case 3 :
                    if (list.length == 0) {
	                    System.out.println("계좌를 생성하세요.");
	                    break;
                    } else {
                    	System.out.println("-----------");
                        System.out.println("입금");
                        System.out.println("-----------");                                  
                        System.out.print("계좌번호: ");
                        String editKey = scanner.nextLine();
                        boolean editExists = true;
                        for (int i = 0; i < list.length; i++) {
                        	if (list[i] != null) {
                        		if (!list[i].getKey().equals(editKey)) {         
	                            	System.out.println("해당 계좌가 존재하지 않습니다.");
	                            	editExists = false;
	                            	break;
                        		} 
                        	}
                        }
                        if (!editExists) {
                            break; // 반복문의 처음으로 돌아감
                        } 
                        String plusNumberString;
                        int plusNumber = 0;
                        while (true) {
                            System.out.print("예금액: ");
                            plusNumberString = scanner.nextLine();
                            try {
                            	plusNumber = Integer.parseInt(plusNumberString);
                                break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                            } catch (NumberFormatException e) {
                                System.out.println("숫자를 입력하세요.");
                            }
                        }                      
                      
                        for (int i = 0; i < list.length; i++) {
                        	if (list[i] != null) {
                        		if (list[i].getKey().equals(editKey)) {         
                        			list[i].deposit(plusNumber);
                        			System.out.println("정상적으로 예금되었습니다.");
	                            	break;
                        		} 
                        	}
                        }
                        break;
                    }
                case 4:
                	if (list.length == 0) {
	                    System.out.println("계좌를 생성하세요.");
	                    break;
                    } else {
                    	System.out.println("-----------");
                        System.out.println("출금");
                        System.out.println("-----------");                                  
                        System.out.print("계좌번호: ");
                        String editKey = scanner.nextLine();
                        boolean editExists = true;
                        for (int i = 0; i < list.length; i++) {
                        	if (list[i] != null) {
                        		if (!list[i].getKey().equals(editKey)) {         
	                            	System.out.println("해당 계좌가 존재하지 않습니다.");
	                            	editExists = false;
	                            	break;
                        		} 
                        	}
                        }
                        if (!editExists) {
                            break; // 반복문의 처음으로 돌아감
                        } 
                        String minusNumberString;
                        int minusNumber = 0;
                        while (true) {
                            System.out.print("출금액: ");
                            minusNumberString = scanner.nextLine();
                            try {
                            	minusNumber = Integer.parseInt(minusNumberString);
                                break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                            } catch (NumberFormatException e) {
                                System.out.println("숫자를 입력하세요.");
                            }
                        }                                            
                        for (int i = 0; i < list.length; i++) {
                        	if (list[i] != null) {
                        		if (list[i].getKey().equals(editKey)) {                        		                     				
	                    				list[i].withdrawl(minusNumber);	                    				
	                    				break;                        				                     		                       			
                        			} 
                        		}
                        	}           
                        break;
                    }
                case 5 :
                    System.out.println("계좌관리 프로그램 종료");
                    break;
                default :
                    System.out.println("1부터 5사이의 숫자를 입력하세요.");
                    break;
            }
        } while (menuNo !=5);
	}
}
