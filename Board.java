package board;

import java.time.*;
import java.time.format.*;
public class Board {
    private int no;
    public static int lastNo = 0;
    private String name;
    private String title;
    private String text;
    private String createdAt;
    private int view = 0;
    private boolean secret;
    private String password;
    // 일반 게시글
    Board(int no, String name, String title, String text, String createdAt, boolean secret) {
        this.no = no;
        this.name = name;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.secret = secret;
    }
    // 비밀글
    Board(int no, String name, String title, String text, String createdAt, boolean secret, String password) {
        this.no = no;
        this.name = name;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.secret = secret;
        this.password = password;
    }
    public int getNo() {
        return no;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public String getPassword() {return password;}
    public int getView() {return view;}
    public boolean isSecret() {
        return secret;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setView() {
        this.view++;
    }
}
