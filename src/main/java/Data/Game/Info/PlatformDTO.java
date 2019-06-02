package Data.Game.Info;

public class PlatformDTO {

    private int platformid;
    private String name;

    public PlatformDTO(int platformid, String name) {
        this.platformid = platformid;
        this.name = name;
    }

    public PlatformDTO() {
    }

    public int getPlatformid() {
        return platformid;
    }

    public void setPlatformid(int platformid) {
        this.platformid = platformid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
