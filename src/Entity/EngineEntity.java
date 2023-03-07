package Entity;

public class EngineEntity {
    private String engine_name;
    private int traction;
    private String fueltype;

    public EngineEntity(String engine_name, int traction, String fueltype) {
        this.engine_name = engine_name;
        this.traction = traction;
        this.fueltype = fueltype;
    }
    public EngineEntity() {
    }

    public String getEName() {
        return engine_name;
    }
    public void setEName(String engine_name) {
        this.engine_name = engine_name;
    }
    public int getTraction() {
        return traction;
    }
    public void setTraction(int traction) {
        this.traction = traction;
    }
    public String getFueltype() {
        return fueltype;
    }
    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    @Override
    public String toString() {
        return "Entity.EngineEntity{" +
                "engine_name=" + engine_name +
                ", traction='" + traction + '\'' +
                ", fueltype=" + fueltype +
                '}';
    }
}
