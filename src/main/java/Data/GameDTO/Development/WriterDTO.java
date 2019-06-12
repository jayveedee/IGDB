package Data.GameDTO.Development;

public class WriterDTO {

    private int             writerID;
    private String          writerFN;
    private String          writerLN;
    private int             writerGAME;

    public WriterDTO(int writerID, String writerFN, String writerLN, int writerGAME) {
        this.writerID = writerID;
        this.writerFN = writerFN;
        this.writerLN = writerLN;
        this.writerGAME = writerGAME;
    }

    public WriterDTO() {
    }

    public int getWriterID() {
        return writerID;
    }

    public void setWriterID(int writerID) {
        this.writerID = writerID;
    }

    public String getWriterFN() {
        return writerFN;
    }

    public void setWriterFN(String writerFN) {
        this.writerFN = writerFN;
    }

    public String getWriterLN() {
        return writerLN;
    }

    public void setWriterLN(String writerLN) {
        this.writerLN = writerLN;
    }

    public int getWriterGAME() {
        return writerGAME;
    }

    public void setWriterGAME(int writerGAME) {
        this.writerGAME = writerGAME;
    }
}
