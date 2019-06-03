package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

import java.util.List;

public class PlatformDTO {

    private int                 platID;
    private String              platNAME;
    private List<GameDTO>       platGAMEs;

    public PlatformDTO(int platID, String platNAME, List<GameDTO> platGAMEs) {
        this.platID = platID;
        this.platNAME = platNAME;
        this.platGAMEs = platGAMEs;
    }

    public PlatformDTO() {
    }

    public int getPlatID() {
        return platID;
    }

    public void setPlatID(int platID) {
        this.platID = platID;
    }

    public String getPlatNAME() {
        return platNAME;
    }

    public void setPlatNAME(String platNAME) {
        this.platNAME = platNAME;
    }

    public List<GameDTO> getPlatGAMEs() {
        return platGAMEs;
    }

    public void setPlatGAMEs(List<GameDTO> platGAMEs) {
        this.platGAMEs = platGAMEs;
    }
}
