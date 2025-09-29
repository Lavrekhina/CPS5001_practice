package plantwateringsystem;

public class WaterPlantSystem {

    //attributes
    private Plant plant;

    //constructor
    public WaterPlantSystem(Plant plant){
        this.plant = plant;
        //this.plant = new Plant("Indoor")
    }
    //methods
    public Plant getPlant(){
        return plant;
    }

    public void waterPlant() {
        //step 1. check soil
        if (this.soilIsDry()) {

            // step 2 select container
            String container = this.selectContainer();
            // step 3 Check if moist enough
            while (!isMoistEnough()) {

                //step 4 Pour some water
                this.pourSomeWater();

                //step 5 Wait for soil to absorb water
                this.waitToAbsorb();
            }
            // step 6 checking the leaves
            this.checkLeaves();
            // step 7 check drainage
            this.checkDrainage();
            // step 8 place potted plant
            this.putPlant();
        }
        // step Stop
    }
    //helper methods
    private boolean soilIsDry(){
        int moistureLevel = plant.getMoistureLevel();
        if (moistureLevel <= 0){
            return true;
        }
        return false;
    }
    private  String selectContainer(){
        int moistureLevel = plant.getMoistureLevel();
        if (moistureLevel <= 2){
            return "Watering Can";
        }
        return "Cup";
    }
    private boolean isMoistEnough() {
        int moistureLevel = plant.getMoistureLevel();
        if (moistureLevel <= 3) {
            return false;
        }
        return true;
    }

    private void pourSomeWater(){
        System.out.println("Poring some water");
        int moistureLevel = plant.getMoistureLevel();
        plant.setMoistureLevel(moistureLevel + 1);
    }
    private void waitToAbsorb(){
        System.out.println("Waiting for water to be absorbed");
    }
    private void checkLeaves(){
        System.out.println("Chekcking leaves do not get wet");
    }
    private void checkDrainage(){
        System.out.println("Chekcking drainage");
    }
    private void putPlant(){
        System.out.println("Placing the plant back");
    }

    public static void main(String[] args) {
        Plant myPlant = new Plant("Indoor");
        WaterPlantSystem system = new WaterPlantSystem(myPlant);
        system.waterPlant();
    }
}