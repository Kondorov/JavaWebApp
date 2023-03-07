package Entity;

public class RocketEntity {
    private String rocket_name;
    private int engines_number;
    private int height;

    public RocketEntity(String rocket_name, int engines_number, int height) {
        this.rocket_name = rocket_name;
        this.engines_number = engines_number;
        this.height = height;
    }
    public  RocketEntity() {
    }

    public String getRName()
    {
        return rocket_name;
    }
    public void setRName(String rocket_name)
    {
        this.rocket_name = rocket_name;
    }
    public int getEnumb() {
        return engines_number;
    }
    public void setEnumb(int engines_number) {
        this.engines_number = engines_number;
    }
    public int getHeight() { return height; }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Entity.RocketEntity{" +
                "rocket_name=" + rocket_name +
                ", engines_number='" + engines_number + '\'' +
                ", height=" + height +
                '}';
    }
}
