package week_1.plantwateringsystem;

import java.util.ArrayList;

public class WaterPlantSystem {

    // attributes
    private ArrayList<Plant> plants;

    // constructor
    public WaterPlantSystem(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    // method to water all plants
    public void waterAllPlants() {
        for (Plant plant : plants) {
            waterPlant(plant);
        }
    }

    // single plant watering logic (reused)
    private void waterPlant(Plant plant) {
        if (soilIsDry(plant)) {
            String container = selectContainer(plant);
            while (!isMoistEnough(plant)) {
                pourSomeWater(plant);
                waitToAbsorb();
            }
            checkLeaves();
            checkDrainage();
            putPlant();
        }
    }

    // helper methods
    private boolean soilIsDry(Plant plant) {
        return plant.getMoistureLevel() == MoistureLevel.DRY;
    }

    private String selectContainer(Plant plant) {
        if (plant.getPlantType() == PlantType.INDOOR) {
            return "Watering Can";
        }
        return "Cup";
    }

    private boolean isMoistEnough(Plant plant) {
        return plant.getMoistureLevel() == MoistureLevel.WET;
    }

    private void pourSomeWater(Plant plant) {
        switch (plant.getMoistureLevel()) {
            case DRY: plant.setMoistureLevel(MoistureLevel.MOIST); break;
            case MOIST: plant.setMoistureLevel(MoistureLevel.WET); break;
        }
    }

    private void waitToAbsorb() {
        System.out.println("Waiting for water to be absorbed...");
    }

    private void checkLeaves() {
        System.out.println("Checking leaves do not get wet...");
    }

    private void checkDrainage() {
        System.out.println("Checking drainage...");
    }

    private void putPlant() {
        System.out.println("Placing the plant back...");
    }

    // optional: summary of all plants after watering
    private void showSummary() {
        int dry = 0, moist = 0, wet = 0;
        for (Plant plant : plants) {
            switch (plant.getMoistureLevel()) {
                case DRY: dry++; break;
                case MOIST: moist++; break;
                case WET: wet++; break;
            }
        }
        System.out.println("Summary: " + dry + " DRY, " + moist + " MOIST, " + wet + " WET");
    }

    public static void main(String[] args) {
        ArrayList<Plant> myPlants = new ArrayList<>();
        myPlants.add(new Plant("Fern", PlantType.INDOOR, MoistureLevel.DRY));
        myPlants.add(new Plant("Rose", PlantType.OUTDOOR, MoistureLevel.MOIST));
        myPlants.add(new Plant("Cactus", PlantType.INDOOR, MoistureLevel.WET));

        WaterPlantSystem system = new WaterPlantSystem(myPlants);
        system.waterAllPlants(); // waters all plants
        system.showSummary();    // prints the summary of all plants
    }
}
