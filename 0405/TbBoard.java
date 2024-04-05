package ex01;

public class TbBoard {
    private int nbBoard;
    private String nmTitle;
    private String nmContent;
    private String nmWriter;
    private String daWrite;
    private int cnHit;
    private String idFile;
    // 파일 없는 게시물
    public TbBoard(int nbBoard, String nmTitle, String nmContent, String nmWriter, String daWrite, int cnHit) {
        this.nbBoard = nbBoard;
        this.nmTitle = nmTitle;
        this.nmContent = nmContent;
        this.nmWriter = nmWriter;
        this.daWrite = daWrite;
        this.cnHit = cnHit;
    }
    // 파일 있는 게시물
    public TbBoard(int nbBoard, String nmTitle, String nmContent, String nmWriter, String daWrite, int cnHit, String idFile) {
        this.nbBoard = nbBoard;
        this.nmTitle = nmTitle;
        this.nmContent = nmContent;
        this.nmWriter = nmWriter;
        this.daWrite = daWrite;
        this.cnHit = cnHit;
        this.idFile = idFile;
    }
    // getters
    public int getNbBoard() {
        return nbBoard;
    }
    public String getNmTitle() {
        return nmTitle;
    }
    public String getNmContent() {
        return nmContent;
    }
    public  String getNmWriter() {
        return nmWriter;
    }
    public String getDaWrite() {
        return daWrite;
    }
    public int getCnHit() {
        return cnHit;
    }
    public String getIdFile() {
        return idFile;
    }
    // setters
    public void setNmTitle(String nmTitle) {
        this.nmTitle = nmTitle;
    }
    public void setNmContent(String nmContent) {
        this.nmContent = nmContent;
    }
    public void setCnHit() {
        this.cnHit += 1;
    }
}
