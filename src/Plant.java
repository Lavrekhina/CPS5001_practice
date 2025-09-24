public class Plant {
    //attributes
    private String name;
    private int moistureLevel;

    //constructor
    public Plant(String name, int level){
        this.name = name;
        this.moistureLevel = level;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public int getMoistureLevel(){
        return this.moistureLevel;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setMoistureLevel(int level){
        this.moistureLevel = moistureLevel;
    }

}
