package Module;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class CardGenerator {
    static String filePrefix = "src/Cards/";
    private static int plantsCount = 0;
    private static int zombieCount = 0;

    public static void importCards() {
        ObjectMapper objectMapper = new ObjectMapper();
        int i = 1;
        while (true) {
            String filePath = filePrefix + "plants/plant" + i + ".json";
            Card plant;
            try {
                plant = objectMapper.readValue(new File(filePath), Plant.class);
            } catch (Exception e) {
                plantsCount = i - 1;
                break;
            }
            Plant.addPlant(plant);
            i += 1;
        }
        i = 1;
        while (true) {
            String filePath = filePrefix + "Zombies/zombie" + i + ".json";
            Card zombie;
            try {
                zombie = objectMapper.readValue(new File(filePath), Zombie.class);
            } catch (Exception e) {
                zombieCount = i - 1;
                break;
            }
            Zombie.addZombie(zombie);
            i += 1;
        }
    }

    public static void generateCard() {

    }
}
