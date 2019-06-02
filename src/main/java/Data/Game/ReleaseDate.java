package Data.Game;

public class ReleaseDate {

    private int day;
    private int month;
    private int yaer;

    public ReleaseDate(int day, int month, int yaer) {
        this.day = day;
        this.month = month;
        this.yaer = yaer;
    }

    public ReleaseDate() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYaer() {
        return yaer;
    }

    public void setYaer(int yaer) {
        this.yaer = yaer;
    }
}
