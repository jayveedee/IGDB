package Data.GameDTO.Development;

import Data.GameDTO.GameDTO;

import java.util.List;

public class WriterDTO {

    private int             wriID;
    private String          wriFN;
    private String          wriLN;
    private List<GameDTO>   wriGAMEs;

    public WriterDTO(int wriID, String wriFN, String wriLN, List<GameDTO> wriGAMEs) {
        this.wriID = wriID;
        this.wriFN = wriFN;
        this.wriLN = wriLN;
        this.wriGAMEs = wriGAMEs;
    }

    public WriterDTO() {
    }

    public int getWriID() {
        return wriID;
    }

    public void setWriID(int wriID) {
        this.wriID = wriID;
    }

    public String getWriFN() {
        return wriFN;
    }

    public void setWriFN(String wriFN) {
        this.wriFN = wriFN;
    }

    public String getWriLN() {
        return wriLN;
    }

    public void setWriLN(String wriLN) {
        this.wriLN = wriLN;
    }

    public List<GameDTO> getWriGAMEs() {
        return wriGAMEs;
    }

    public void setWriGAMEs(List<GameDTO> wriGAMEs) {
        this.wriGAMEs = wriGAMEs;
    }
}
