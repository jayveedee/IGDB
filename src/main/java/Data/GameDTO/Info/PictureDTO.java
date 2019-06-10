package Data.GameDTO.Info;

public class PictureDTO {

    private int         picID;
    private String      picURL;
    private int         picGameID;

    public PictureDTO(int picID, String picURL, int picGameID) {
        this.picID = picID;
        this.picURL = picURL;
        this.picGameID = picGameID;
    }

    public PictureDTO() {
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getPicGameID() {
        return picGameID;
    }

    public void setPicGameID(int picGameID) {
        this.picGameID = picGameID;
    }
}
