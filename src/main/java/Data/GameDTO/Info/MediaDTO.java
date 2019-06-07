package Data.GameDTO.Info;

import java.util.List;

public class MediaDTO {

    private List<String> mediaTRAILER;
    private List<String> mediaOTHER;

    public MediaDTO() {
    }

    public MediaDTO(List<String> mediaTRAILER, List<String> mediaOTHER) {
        this.mediaTRAILER = mediaTRAILER;
        this.mediaOTHER = mediaOTHER;
    }

    public List<String> getMediaTRAILER() {
        return mediaTRAILER;
    }

    public void setMediaTRAILER(List<String> mediaTRAILER) {
        this.mediaTRAILER = mediaTRAILER;
    }

    public List<String> getMediaOTHER() {
        return mediaOTHER;
    }

    public void setMediaOTHER(List<String> mediaOTHER) {
        this.mediaOTHER = mediaOTHER;
    }
}
