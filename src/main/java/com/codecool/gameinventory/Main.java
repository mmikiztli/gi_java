package com.codecool.gameinventory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marti on 2017.04.13.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Integer> example = new HashMap<>();
        example.put("rope", 1);
        example.put("torch", 6);
        example.put("gold coin", 42);
        example.put("dagger", 1);
        example.put("arrow", 12);

        GameInventory inventory = new GameInventory(example);

        inventory.display();

        List<String> dragonLoot = Arrays.asList("gold coin", "dagger", "gold coin", "gold coin", "ruby");

        System.out.println(dragonLoot);
        inventory.addAll(dragonLoot);
        inventory.display();

        System.out.println(inventory.longestItem("value"));
        inventory.printTable();

    }
}
