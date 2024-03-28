package java_09_1_ex1_studentManager;

import java.util.*;

public class StudentManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int menuNo;
        List<Student> list = new ArrayList<Student>(100);
        
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. 학생 추가 | 2: 학생 목록 | 3: 학생 수정 | 4: 학생 삭제 | 5: 종료");
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
                    System.out.println("학생 추가");
                    System.out.println("-----------");
                    String keyString;
                    int key = 0;
                    while (true) {
                        System.out.print("학번(key): ");
                        keyString = scanner.nextLine();
                        try {
                            key = Integer.parseInt(keyString);
                            break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력하세요.");
                        }
                    }
                    boolean studentExists = false;
                    for (Student i : list) {
                        if (i.getKey() == key) {         
                        	System.out.println("학생이 이미 존재합니다.");
                        	studentExists = true;
                        	break;
                        } 
                    }
                    if (studentExists) {
                        break; // 반복문의 처음으로 돌아감
                    } 
                    System.out.print("이름: ");
                    String name = scanner.nextLine();
                    String ageString;
                    int age = 0;
                    while (true) {
                        System.out.print("나이: ");
                        ageString = scanner.nextLine();
                        try {
                            age = Integer.parseInt(ageString);
                            break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력하세요.");
                        }
                    }
                    System.out.print("전공: ");
                    String major = scanner.nextLine();
                    Student student = new Student(key, name, age, major);
                    list.add(student);
                    System.out.println("학생을 추가하였습니다.");
                    break;
                case 2 :
                    if (list.isEmpty()) {
                        System.out.println("학생을 입력하세요..");
                        break;
                    } else {
                        System.out.println("-----------");
                        System.out.println("학생 목록");
                        System.out.println("-----------");
                        for (Student i: list) {
                        	System.out.println(i.getName()+ "    " + i.getAge() + "     " + i.getKey() + "     " + i.getMajor());
                        }                        	
                        break;
                    }
                case 3 :
                    if (list.isEmpty()) {
	                    System.out.println("학생을 입력하세요..");
	                    break;
                    } else {
                    	System.out.println("-----------");
                        System.out.println("학생 수정");
                        System.out.println("-----------");
                        String editKeyString;
                        int editKey = 0;
                        while (true) {
                            System.out.print("학번(key): ");
                            editKeyString = scanner.nextLine();
                            try {
                            	editKey = Integer.parseInt(editKeyString);
                                break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                            } catch (NumberFormatException e) {
                                System.out.println("숫자를 입력하세요.");
                            }
                        }
                        boolean editStudentExists = true;
                        for (Student i : list) {
                            if (i.getKey() != editKey) {         
                            	System.out.println("해당 학번의 학생이 존재하지 않습니다.");
                            	editStudentExists = false;
                            	break;
                            } 
                        }
                        if (!editStudentExists) {
                            break; // 반복문의 처음으로 돌아감
                        } 
                        System.out.print("이름: ");
                        String editName = scanner.nextLine();
                        String editAgeString;
                        int editAge = 0;
                        while (true) {
                            System.out.print("나이: ");
                            editAgeString = scanner.nextLine();
                            try {
                            	editAge = Integer.parseInt(editAgeString);
                                break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                            } catch (NumberFormatException e) {
                                System.out.println("숫자를 입력하세요.");
                            }
                        }
                       
                        System.out.print("전공: ");
                        String editMajor = scanner.nextLine();
                        for (Student i : list) {
                            if (i.getKey() == editKey) {
                                i.setAge(editAge);
                                i.setName(editName);
                                i.setMajor(editMajor);
                                break; // 수정이 완료되었으므로 반복문 종료
                            }
                        }
                        break;
                    }
                case 4:
                    if (list.isEmpty()) {
                    System.out.println("학생을 입력하세요.");
                    break;
                } else {
                	System.out.println("-----------");
                    System.out.println("학생 추가");
                    System.out.println("-----------");
                    String editKeyString;
                    int deleteKey = 0;
                    while (true) {
                        System.out.print("학번(key): ");
                        editKeyString = scanner.nextLine();
                        try {
                        	deleteKey = Integer.parseInt(editKeyString);
                            break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력하세요.");
                        }
                    }
                    boolean deleteStudentExists = true;
                    for (Student i : list) {
                        if (i.getKey() != deleteKey) {         
                        	System.out.println("해당 학번의 학생이 존재하지 않습니다.");
                        	deleteStudentExists = false;
                        	break;
                        } 
                    }
                    if (!deleteStudentExists) {
                        break; // 반복문의 처음으로 돌아감
                    } 
                    for (Student i : list) {
                        if (i.getKey() == deleteKey) {
                            list.remove(i);
                            System.out.println("학생을 삭제하였습니다.");
                            break; 
                        }
                    }                    
                }
                case 5 :
                    System.out.println("프로그램 종료");
                    break;
                default :
                    System.out.println("1부터 5사이의 숫자를 입력하세요.");
                    break;
            }
        } while (menuNo !=5);

	}
}
