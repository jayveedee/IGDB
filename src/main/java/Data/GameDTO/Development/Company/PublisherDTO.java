package Data.GameDTO.Development.Company;

import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class PublisherDTO {

    private int companyid;
    private String name;
    private DateDTO established;
    private String country;
    private boolean status;
    private List<GameDTO> gameList;

    private String biography;

    public PublisherDTO(int companyid, String name, DateDTO established, String country, boolean status, List<GameDTO> gameList, String biography) {
        this.companyid = companyid;
        this.name = name;
        this.established = established;
        this.country = country;
        this.status = status;
        this.gameList = gameList;
        this.biography = biography;
    }

    public PublisherDTO() {
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
