package Entity;

public class CosmodromeEntity {
    private String cosmodrome_name;
    private String country;
    private String timezone;

    public CosmodromeEntity(String cosmodrome_name, String country, String timezone) {
        this.cosmodrome_name = cosmodrome_name;
        this.country = country;
        this.timezone = timezone;
    }
    public  CosmodromeEntity() {
    }

    public String getCName() {
        return cosmodrome_name;
    }
    public void setCName(String cosmodrome_name) {
        this.cosmodrome_name = cosmodrome_name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Entity.CosmodromeEntity{" +
                "cosmodrome_name=" + cosmodrome_name +
                ", country='" + country + '\'' +
                ", timezone=" + timezone +
                '}';
    }
}

