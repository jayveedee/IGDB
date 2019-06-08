package Data.GameDTO.Info;

public class PictureDTO {

    private int         picID;
    private String      picURL;

    public PictureDTO(int picID, String picURL) {
        this.picID = picID;
        this.picURL = picURL;
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
}
