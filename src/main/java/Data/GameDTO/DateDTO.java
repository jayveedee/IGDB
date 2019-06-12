package Data.GameDTO;

public class DateDTO {

    private String day;
    private String month;
    private String yaer;

    public DateDTO(String day, String month, String yaer) {
        this.day = day;
        this.month = month;
        this.yaer = yaer;
    }

    public DateDTO() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYaer() {
        return yaer;
    }

    public void setYaer(String yaer) {
        this.yaer = yaer;
    }
}
