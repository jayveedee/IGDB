package Data.GameDTO;

public class DateDTO {

    private String day;
    private String month;
    private String year;

    public DateDTO(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getDateString(){
        return day + "/" + month + "/" + year;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)