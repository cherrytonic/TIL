package ex01;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CRUD {
    // 글 작성
    public static void insertQuery(Connection con, String nmTitle, String nmContent, String nmWriter) {
        try {
            String sql = "INSERT INTO TB_BOARD(NB_BOARD, NM_TITLE, NM_CONTENT, NM_WRITER)"
                    + "VALUES(SEQ_TB_BOARD.NEXTVAL, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nmTitle);
            pstmt.setString(2, nmContent);
            pstmt.setString(3, nmWriter);
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);
            // 쿼리 작성 및 실행
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertFile(Connection con, String filePath) {
        try {
            byte[] imageData = convertImageToByteArray(filePath);
            // 쿼리 작성 및 실행
            String sql2 = "INSERT INTO TB_CONTENT(ID_FILE, BO_SAVE_FILE)"
                    + "VALUES(TO_CHAR(SEQ_TB_CONTENT.NEXTVAL), ?)";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setBytes(1, imageData);
            pstmt2.executeUpdate();
            pstmt2.close();
        } catch (Exception e) {
            System.out.println("이미지 저장 실패: " + e.getMessage());
        }
    }
    public static void viewCount(Connection con, int nb_board, String idFile) {
        try {
            String sql1 = "UPDATE TB_BOARD SET CN_HIT = CN_HIT + 1 WHERE NB_BOARD = ?";
            PreparedStatement pstmt1 = con.prepareStatement(sql1);
            pstmt1.setInt(1, nb_board);
            pstmt1.close();
            String sql2 = "SELECT ID_FILE FROM TB_CONTENT WHERE NB_BOARD = ?";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, nb_board);
            ResultSet rs = pstmt2.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getString(1)
                );
            }
            String sql3 = "UPDATE TB_CONTENT SET CN_HIT = CN_HIT + 1 WHERE ID_FILE = ?";
            PreparedStatement pstmt3 = con.prepareStatement(sql3);
            pstmt3.setString(1, rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 글 조회
//    public static void selectQuery(Connection con) {
//        try {
//            String sql = "SELECT NB_BOARD, NM_TITLE, NM_WRITER, TO_CHAR(DA_WRITER, 'YYYY-MM-DD'), CN_HIT FROM TB_BOARD ORDER BY NB_BOARD";
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.println(
//                        String.format("%-4s | %-15s | %-15s | %-12s | %-8s ",
//                                rs.getString(1),
//                                abbreviateString(rs.getString(2), 10),
//                                abbreviateString(rs.getString(3), 10),
//                                rs.getString(4),
//                                rs.getString(5)
//                ));
//            }
//            rs.close();
//            pstmt.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static ArrayList<TbBoard> selectQuery(Connection con) {
        ArrayList<TbBoard> tbBoardList = new ArrayList<>();
        try {
            String sql = "SELECT NB_BOARD, NM_TITLE, NM_CONTENT, NM_WRITER, TO_CHAR(DA_WRITER, 'YYYY-MM-DD'), CN_HIT FROM TB_BOARD ORDER BY NB_BOARD";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TbBoard tbBoard = new TbBoard(
                        rs.getInt(1),
                        abbreviateString(rs.getString(2), 10),
                        abbreviateString(rs.getString(3), 10),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
                tbBoardList.add(tbBoard);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbBoardList;
    }
    // 글 수정
    public static void updateQuery(Connection con) {
        try {
            String sql = new StringBuilder().append("UPDATE USERS SET ").append("NM_USER=?, ").append("ID_EMAIL=? ").append("WHERE NM_USER =? ").toString();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "길동 홍");
            pstmt.setString(2, "abc@ddd.com");
            pstmt.setString(3, "홍길동");
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: " + rows);
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 글 삭제
    public static void deleteQuery(Connection con) {
        try {
            String sql = new StringBuilder().append("DELETE FROM USERS ").append("WHERE NM_USER =? ").toString();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "홍길동");
            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: " + rows);
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // 이미지 파일을 바이트 배열로 변환하는 메서드
    private static byte[] convertImageToByteArray(String filePath) throws Exception {
        File imageFile = new File(filePath);
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (InputStream inputStream = new FileInputStream(imageFile)) {
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }
        return baos.toByteArray();
    }
    private static String abbreviateString(String str, int maxLength) {
        if (str.length() > maxLength) {
            return str.substring(0, maxLength - 3) + "...";
        }
        return str;
    }
}
