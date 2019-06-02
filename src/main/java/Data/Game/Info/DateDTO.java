package Data.Game.Info;

public class DateDTO {

    private int day;
    private int month;
    private int yaer;

    public DateDTO(int day, int month, int yaer) {
        this.day = day;
        this.month = month;
        this.yaer = yaer;
    }

    public DateDTO() {
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
