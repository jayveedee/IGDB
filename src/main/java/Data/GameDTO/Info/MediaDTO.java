package Data.GameDTO.Info;

import java.util.List;

public class MediaDTO {

    private List<String> mediaTRAILER;
    private List<String> mediaCOVER;
    private List<String> mediaBG;
    private List<String> mediaOTHER;

    public MediaDTO() {
    }

    public MediaDTO(List<String> mediaTRAILER, List<String> mediaCOVER, List<String> mediaBG, List<String> mediaOTHER) {
        this.mediaTRAILER = mediaTRAILER;
        this.mediaCOVER = mediaCOVER;
        this.mediaBG = mediaBG;
        this.mediaOTHER = mediaOTHER;
    }

    public List<String> getMediaTRAILER() {
        return mediaTRAILER;
    }

    public void setMediaTRAILER(List<String> mediaTRAILER) {
        this.mediaTRAILER = mediaTRAILER;
    }

    public List<String> getMediaCOVER() {
        return mediaCOVER;
    }

    public void setMediaCOVER(List<String> mediaCOVER) {
        this.mediaCOVER = mediaCOVER;
    }

    public List<String> getMediaBG() {
        return mediaBG;
    }

    public void setMediaBG(List<String> mediaBG) {
        this.mediaBG = mediaBG;
    }

    public List<String> getMediaOTHER() {
        return mediaOTHER;
    }

    public void setMediaOTHER(List<String> mediaOTHER) {
        this.mediaOTHER = mediaOTHER;
    }
}
