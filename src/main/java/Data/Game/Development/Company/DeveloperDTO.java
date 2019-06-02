package Data.Game.Development.Company;

import Data.Game.Info.DateDTO;
import Data.Game.GameDTO;

import java.util.List;

public class DeveloperDTO {

    private int developerid;
    private String name;
    private DateDTO established;
    private boolean status;
    private String country;
    private PublisherDTO parentCompany;
    private List<GameDTO> gameList;

    private String biography;

    public DeveloperDTO(int developerid, String name, DateDTO established, boolean status, String country, PublisherDTO parentCompany, List<GameDTO> gameList, String biography) {
        this.developerid = developerid;
        this.name = name;
        this.established = established;
        this.status = status;
        this.country = country;
        this.parentCompany = parentCompany;
        this.gameList = gameList;
        this.biography = biography;
    }

    public DeveloperDTO() {
    }

    public int getDeveloperid() {
        return developerid;
    }

    public void setDeveloperid(int developerid) {
        this.developerid = developerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateDTO getEstablished() {
        return established;
    }

    public void setEstablished(DateDTO established) {
        this.established = established;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PublisherDTO getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(PublisherDTO parentCompany) {
        this.parentCompany = parentCompany;
    }

    public List<GameDTO> getGameList() {
        return gameList;
    }

    public void setGameList(List<GameDTO> gameList) {
        this.gameList = gameList;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
