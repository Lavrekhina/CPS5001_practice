package week_1.plantwateringsystem;

enum MoistureLevel {
    DRY,
    MOIST,
    WET
}

enum PlantType {
    INDOOR,
    OUTDOOR
}

public class Plant {
    // attributes
    private String name;
    private MoistureLevel moistureLevel;
    private PlantType plantType;

    // constructor
    public Plant(String name, PlantType plantType, MoistureLevel initialMoisture) {
        this.name = name;
        this.moistureLevel = initialMoisture;
        this.plantType = plantType;
    }

    // getters
    public String getName() {
        return name;
    }

    public MoistureLevel getMoistureLevel() {
        return moistureLevel;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMoistureLevel(MoistureLevel moistureLevel) {
        this.moistureLevel = moistureLevel;
    }
}
