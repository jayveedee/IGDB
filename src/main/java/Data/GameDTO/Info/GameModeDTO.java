package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

import java.util.List;

public class GameModeDTO {

    private int                 gmID;
    private String              gmNAME;
    private List<GameDTO>       gmGAMEs;

    public GameModeDTO(int gmID, String gmNAME, List<GameDTO> gmGAMEs) {
        this.gmID = gmID;
        this.gmNAME = gmNAME;
        this.gmGAMEs = gmGAMEs;
    }

    public GameModeDTO() {
    }

    public int getGmID() {
        return gmID;
    }

    public void setGmID(int gmID) {
        this.gmID = gmID;
    }

    public String getGmNAME() {
        return gmNAME;
    }

    public void setGmNAME(String gmNAME) {
        this.gmNAME = gmNAME;
    }

    public List<GameDTO> getGmGAMEs() {
        return gmGAMEs;
    }

    public void setGmGAMEs(List<GameDTO> gmGAMEs) {
        this.gmGAMEs = gmGAMEs;
    }
}
