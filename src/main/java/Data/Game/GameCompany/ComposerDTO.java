package Data.Game.GameCompany;

import Data.Game.GameDTO;
import Data.Game.SoundtrackDTO;

import java.util.List;

public class ComposerDTO {

    private int composerid;
    private String firstName;
    private String lastName;
    private List<SoundtrackDTO> soundtrackDTOList;
    private List<GameDTO> starredin;

    public ComposerDTO(int composerid, String firstName, String lastName, List<SoundtrackDTO> soundtrackDTOList, List<GameDTO> starredin) {
        this.composerid = composerid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.soundtrackDTOList = soundtrackDTOList;
        this.starredin = starredin;
    }

    public ComposerDTO() {
    }

    public int getComposerid() {
        return composerid;
    }

    public void setComposerid(int composerid) {
        this.composerid = composerid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoundtrackDTO> getSoundtrackDTOList() {
        return soundtrackDTOList;
    }

    public void setSoundtrackDTOList(List<SoundtrackDTO> soundtrackDTOList) {
        this.soundtrackDTOList = soundtrackDTOList;
    }

    public List<GameDTO> getStarredin() {
        return starredin;
    }

    public void setStarredin(List<GameDTO> starredin) {
        this.starredin = starredin;
    }
}
