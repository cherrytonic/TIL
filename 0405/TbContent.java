package ex01;

public class TbContent {
    private String idFile;
    private String nmOrgFile;
    private String boSaveFile;
    private String nmFileExt;
    private String daSave;
    private int cnHit;

    public TbContent(String idFile, String nmOrgFile, String boSaveFile, String nmFileExt, String daSave, int cnHit) {
        this.idFile = idFile;
        this.nmOrgFile = nmOrgFile;
        this.boSaveFile = boSaveFile;
        this.nmFileExt = nmFileExt;
        this.daSave = daSave;
        this.cnHit = cnHit;
    }
    // getters
    public String getIdFile() {
        return idFile;
    }
    public String getNmOrgFile() {
        return nmOrgFile;
    }
    public String getBoSaveFile() {
        return boSaveFile;
    }
    public  String getNmFileExt() {
        return nmFileExt;
    }
    public String getDaSave() {
        return daSave;
    }
    public int getCnHit() {
        return cnHit;
    }
    // setters
    public void setCnHit() {
        this.cnHit += 1;
    }

}
