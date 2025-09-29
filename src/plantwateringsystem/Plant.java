package plantwateringsystem;

public class Plant {
    //attributes / fields / variables
    private String name;
    private int moistureLevel;
    private String plantType;

    //constructor
    public Plant(String plantType) {
        name = "";
        moistureLevel = 0;
        this.plantType = plantType;

    }
    // methods
    //getters
    public String getName(){
        return name;
    }
    public int getMoistureLevel(){
        return moistureLevel;
    }
    public String getPlantType(){
        return plantType;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setMoistureLevel(int moistureLevel){
        this.moistureLevel = moistureLevel;
    }

}
