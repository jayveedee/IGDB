package Data.GameDTO.Development;

import java.util.List;

public class WriterDTO {

    private int             writerID;
    private String          writerFN;
    private String          writerLN;
    private List<Integer>   writerGAMEs;

    public WriterDTO(int writerID, String writerFN, String writerLN, List<Integer> writerGAMEs) {
        this.writerID = writerID;
        this.writerFN = writerFN;
        this.writerLN = writerLN;
        this.writerGAMEs = writerGAMEs;
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

    public List<Integer> getWriterGAMEs() {
        return writerGAMEs;
    }

    public void setWriterGAMEs(List<Integer> writerGAMEs) {
        this.writerGAMEs = writerGAMEs;
    }
}
