package plantwateringsystem;

import java.util.ArrayList;
import java.util.Random;

public class PerformanceTester {

    public static void main(String[] args) {
        // Test with different numbers of plants
        int[] sizes = {100, 1000, 10000, 50000};

        for (int size : sizes) {
            ArrayList<Plant> plants = generatePlants(size);

            WaterPlantSystem system = new WaterPlantSystem(plants);

            long startTime = System.nanoTime();
            system.waterAllPlants();  // new method that waters all plants
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Time taken to water " + size + " plants: " + duration + " ns");
        }
    }

    // Helper: generate random plants with random moisture levels
    private static ArrayList<Plant> generatePlants(int size) {
        ArrayList<Plant> plants = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            PlantType type = (i % 2 == 0) ? PlantType.INDOOR : PlantType.OUTDOOR;

            MoistureLevel moisture = switch (random.nextInt(3)) {
                case 0 -> MoistureLevel.DRY;
                case 1 -> MoistureLevel.MOIST;
                default -> MoistureLevel.WET;
            };

            Plant plant = new Plant("Plant_" + i, type, moisture);
            plants.add(plant);
        }
        return plants;
    }

}
