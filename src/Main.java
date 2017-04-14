import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by marti on 2017.04.13..
 */
public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
        ArrayList<String> dragonLoot = new ArrayList<>();
        GameInventory.exampleInv(inventory);
        GameInventory.displayInventory(inventory);
        GameInventory.exampleLoot(dragonLoot);
        System.out.println(dragonLoot);
        GameInventory.addToInventory(inventory,dragonLoot);
        GameInventory.displayInventory(inventory);
        System.out.println(GameInventory.longestItem(inventory,"value"));
        GameInventory.printTable(inventory);

    }
}
