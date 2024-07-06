package modelo;

public class Season {
    private int year;
    private String url;
    
    public Season(int year, String url) {
        this.year = year;
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}   
