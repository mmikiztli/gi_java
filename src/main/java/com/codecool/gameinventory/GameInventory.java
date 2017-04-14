package com.codecool.gameinventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

/**
 * Created by marti on 2017.04.13..
 */
public class GameInventory {

    private final Map<String, Integer> inventory;

    public GameInventory() {
        this.inventory = new HashMap<>();
    }

    public GameInventory(Map<String, Integer> inventory) {
        this.inventory = new HashMap<>(inventory);
    }

    public void display() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            total += value;

            System.out.println(value + " " + key);
        }
        System.out.println("Total number of items: " + total);
    }

    public void addAll(Collection<String> loots) {
        for (String loot : loots) {
            inventory.merge(loot, 1, Integer::sum);
        }
    }

    public int longestItem(String type) {
        int max = 0;
        switch (type) {
            case "key":
                for (String key : inventory.keySet()) {
                    if (key.length() > max) {
                        max = key.length();
                    }
                }
                break;
            case "value":
                Integer maxVal = Integer.toString(Collections.max(inventory.values()))
                                        .length();
                if (maxVal < "count".length()) {
                    max = "count".length();
                }
                break;

        }
        return max;
    }

    public void printTable() {
        String heading1 = "count";
        String heading2 = "item name";
        System.out.println("Inventory:");

        int maxLengthKey = this.longestItem("key");
        int maxLengthValue = this.longestItem("value");
        int total = 0;
        Integer n1;
        Integer n2;
        String s = " ";
        String d = "-";
        String divider = new String(new char[maxLengthKey + maxLengthValue + 4]).replace("\0", d);
        String paddingCount = new String(new char[maxLengthValue - heading1.length()]).replace("\0", s);
        String paddingItemName = new String(new char[maxLengthKey - heading2.length()]).replace("\0", s);
        System.out.print(paddingCount + heading1 + "    ");
        System.out.println(paddingItemName + heading2);
        System.out.println(divider);
        for (HashMap.Entry<String, Integer> entry : inventory.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            total += value;
            n1 = maxLengthKey - key.length() + 2;
            n2 = maxLengthValue - Integer.toString(value)
                                         .length();
            String paddingKey = new String(new char[n1]).replace("\0", s);
            String paddingValue = new String(new char[n2]).replace("\0", s);
            System.out.print(paddingValue + value + "  ");
            System.out.println(paddingKey + key);

        }
        System.out.println(divider);
        System.out.println("Total number of items: " + total);
    }


    //switch (order) {
    //case "count,desc" :
    //case "count,asc" :
    //default: }
}

