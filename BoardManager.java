package board;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class BoardManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainMenuNo;
        int id = 0;
        List<Board> list = new ArrayList<Board>(100);
        mainMenuLoop:
        do {
            System.out.println("===========================");
            System.out.println("자유게시판");
            System.out.println("===========================");
            System.out.println("메인메뉴 : 1. 목록 조회  |  2. 종료");
            System.out.print("선택>");
            while (true) {
                String mainMenuNoString = scanner.nextLine();
                try {
                    mainMenuNo = Integer.parseInt(mainMenuNoString);
                    break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                } catch (NumberFormatException e) {
                    System.out.println("1이나 2의 숫자를 입력하세요.");
                }
            }
            switch (mainMenuNo) {
                case 1:
                    int menuNo;
                    menuLoop:
                    do{
                        System.out.println("-----------------------");
                        System.out.println("번호  |  제목  |  작성자  |  작성일자  |  조회수  |  비밀글");
                        System.out.println("-----------------------");
                        for (Board i : list) {
                            String isSecret = (i.isSecret()) ? "비밀" : " ";
                            System.out.println(i.getNo() + "\t\t" + i.getTitle() + "\t\t" + i.getName() + "\t\t" + i.getCreatedAt() + "\t\t" + i.getView() + "\t\t" + isSecret);
                        }
                        System.out.println("  1. 글 작성 | 2. 상세 조회 | 3. 다중 삭제 | 4. 메인메뉴 이동");
                        System.out.print("선택>");
                        while (true) {
                            String menuNoString = scanner.nextLine();
                            try {
                                menuNo = Integer.parseInt(menuNoString);
                                break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                            } catch (NumberFormatException e) {
                                System.out.println("1~4 사이의 숫자를 입력하세요.");
                            }
                        }
                        switch (menuNo) {
                            // 글 작성
                            case 1:
                                System.out.println("-----------");
                                System.out.println("글 작성");
                                System.out.println("-----------");
                                System.out.print("제목: ");
                                String title = scanner.nextLine();
                                System.out.print("이름: ");
                                String name = scanner.nextLine();
                                System.out.print("내용: ");
                                String text = scanner.nextLine();
                                String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                                String secretChar;
                                do {
                                    System.out.print("비밀글 여부(y/n): ");
                                    secretChar = scanner.nextLine();
                                    if (!secretChar.equals("y") && !secretChar.equals("n")) {
                                        System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                                    }
                                } while (!secretChar.equals("y") && !secretChar.equals("n"));
                                boolean secret;
                                String password = null;
                                if (secretChar.equals("y")) {
                                    secret = true;
                                    do {
                                        System.out.print("비밀번호(숫자 네 자리): ");
                                        password = scanner.nextLine();
                                        if (password.length() != 4 || !password.matches("[0-9]+")) {
                                            System.out.println("비밀번호는 네 자리의 숫자여야 합니다. 다시 입력하세요.");
                                        }
                                    } while (password.length() != 4 || !password.matches("[0-9]+"));
                                } else  {
                                    secret = false;
                                }
                                Board article;
                                if (secret) {
                                    article = new Board(id++, name, title, text, createdAt, secret, password);
                                } else {
                                    article = new Board(id++, name, title, text, createdAt, secret);
                                }
                                list.add(article);
                                System.out.println("게시글 작성 성공!");
                                continue;
                            // 상세 조회
                            case 2:
                                if (list.isEmpty()) {
                                    System.out.println("게시글이 존재하지 않습니다.");
                                    continue;
                                }
                                System.out.println("-----------");
                                System.out.println("상세 조회");
                                System.out.println("-----------");
                                int idNo = 0;
                                System.out.print("조회할 글 번호: ");
                                String idString = scanner.nextLine();
                                try {
                                    idNo = Integer.parseInt(idString);
                                } catch (NumberFormatException e) {
                                    System.out.println("숫자를 입력하세요.");
                                }
                                boolean found = false;
                                for (Board i: list) {
                                    if (i.getNo() == idNo) {
                                        i.setView();
                                        found = true;
                                        if(i.isSecret()) {
                                            System.out.print("비밀번호 입력: ");
                                            String passwordInput = scanner.nextLine();
                                            if (!i.getPassword().equals(passwordInput)) {
                                                System.out.println("비밀번호가 일치하지 않습니다.");
                                                continue;
                                            }
                                        }
                                            int detailNo;
                                            detailLoop:
                                            do {
                                                System.out.println("제목: " + i.getTitle());
                                                System.out.println("작성자: " + i.getName());
                                                System.out.println("작성일자: " + i.getCreatedAt());
                                                System.out.println("조회수: " + i.getView());
                                                System.out.println("내용: " + i.getText());
                                                System.out.println("  1. 글 수정 | 2. 글 삭제 | 3. 메인메뉴 이동");
                                                System.out.print("선택>");
                                                while (true) {
                                                    String detailNoString = scanner.nextLine();
                                                    try {
                                                        detailNo = Integer.parseInt(detailNoString);
                                                        break;  // 숫자를 정상적으로 입력받았으면 반복문 종료
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("1이나 2의 숫자를 입력하세요.");
                                                    }
                                                }
                                                switch (detailNo) {
                                                    // 글 수정
                                                    case 1:
                                                        System.out.println("-----------");
                                                        System.out.println("글 수정");
                                                        System.out.println("-----------");
                                                        if(i.isSecret()) {
                                                            System.out.print("비밀번호 입력: ");
                                                            String passwordInput = scanner.nextLine();
                                                            if (!i.getPassword().equals(passwordInput)) {
                                                                System.out.println("비밀번호가 일치하지 않습니다.");
                                                                continue;
                                                            }
                                                        }
                                                        System.out.println("제목: " + i.getTitle());
                                                        System.out.println("작성자: " + i.getName());
                                                        System.out.println("작성일자: " + i.getCreatedAt());
                                                        System.out.println("조회수: " + i.getView());
                                                        System.out.println("내용: " + i.getText());
                                                        System.out.println("-----------------------------");
                                                        System.out.print("새로운 제목을 입력하세요: ");
                                                        String newTitle = scanner.nextLine();
                                                        i.setTitle(newTitle);
                                                        System.out.print("새로운 내용을 입력하세요: ");
                                                        String newText = scanner.nextLine();
                                                        i.setText(newText);
                                                        System.out.println("잘못된 입력입니다. 제목 또는 내용을 입력하세요.");
                                                        System.out.println("글이 수정되었습니다.");
                                                        break;
                                                    // 글 삭제
                                                    case 2:
                                                        System.out.println("-----------");
                                                        System.out.println("글 삭제");
                                                        System.out.println("-----------");
                                                        if(i.isSecret()) {
                                                            System.out.print("비밀번호 입력: ");
                                                            String passwordInput = scanner.nextLine();
                                                            if (!i.getPassword().equals(passwordInput)) {
                                                                System.out.println("비밀번호가 일치하지 않습니다.");
                                                                continue;
                                                            }
                                                        }
                                                        list.remove(i);
                                                        System.out.println("삭제에 성공했습니다.");
                                                        break menuLoop;
                                                    // 메인메뉴 이동
                                                    case 3:
                                                        break menuLoop;
                                                    default:
                                                        System.out.println("메인메뉴 이동");
                                                        break;
                                                }
                                            } while (detailNo != 3);
                                    }
                                }
                                if (!found) {
                                    System.out.println("게시글이 존재하지 않습니다.");
                                }
                                continue;
                            // 다중 삭제    
                            case 3:
                                if (list.isEmpty()) {
                                    System.out.println("게시글이 존재하지 않습니다.");
                                    continue;
                                }
                                System.out.println("-----------");
                                System.out.println("다중 삭제");
                                System.out.println("-----------");
                                // 비밀글이 있는지 확인하는 변수
                                boolean hasSecret = false;
                                List<Integer> deleteList = new ArrayList<>();
                                System.out.print("삭제할 글 번호를 띄어쓰기로 구분해서 입력하세요(최대 10개): ");
                                String deleteString = scanner.nextLine();
                                // 입력된 번호들을 공백을 기준으로 분리하여 리스트에 저장
                                String[] deleteNumbers = deleteString.split(" ");
                                for (String deleteNumber : deleteNumbers) {
                                    try {
                                        int deleteNo = Integer.parseInt(deleteNumber);
                                        deleteList.add(deleteNo);
                                    } catch (NumberFormatException e) {
                                        System.out.println("숫자 형식에 맞게 입력하세요.");
                                    }
                                }
                                for (Integer deleteNo : deleteList) {
                                    for (Board board : list) {
                                        if (board.getNo() == deleteNo && board.isSecret()) {
                                            hasSecret = true;
                                            break;
                                        }
                                    }
                                    if (hasSecret) {
                                        System.out.println("비밀글이 포함되어 삭제가 불가능합니다.");
                                        break;
                                    }
                                }
                                // 저장된 번호들을 이용하여 삭제 진행
                                if (!hasSecret) {
                                    for (Integer deleteNo : deleteList) {
                                        boolean deleteFound = false;
                                        for (int i = 0; i < list.size(); i++) {
                                            Board board = list.get(i);
                                            if (board.getNo() == deleteNo) {
                                                if (!board.isSecret()) {
                                                    list.remove(i);
                                                    deleteFound = true;
                                                    System.out.println("삭제 성공!");
                                                }
                                            }
                                        }
                                        if (!deleteFound) {
                                            System.out.println("글 번호 " + deleteNo + "는 존재하지 않습니다.");
                                        }
                                    }
                                }
                                continue;
                            // 메인메뉴 이동
                            case 4:
                                System.out.println("메인메뉴 이동");
                                break;
                            default:
                                System.out.println("1~4 사이의 숫자를 입력하세요.");
                                continue;
                        }
                        break;
                    } while(menuNo != 4);
                    break;
                case 2:
                    System.out.println("프로그램 종료");
                    break;
                default:
                    System.out.println("1이나 2의 숫자를 입력하세요.");
                    break;
            }
        } while(mainMenuNo !=2);
    }
}
