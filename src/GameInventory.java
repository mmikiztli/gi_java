import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Collections;

/**
 * Created by marti on 2017.04.13..
 */
public class GameInventory {

    //inv = {'rope': 1, 'torch': 6, 'gold coin': 42, 'dagger': 1, 'arrow': 12}

    public static void exampleInv(LinkedHashMap<String, Integer> inv) {
        inv.put("rope", 1);
        inv.put("torch", 6);
        inv.put("gold coin", 42);
        inv.put("dagger", 1);
        inv.put("arrow", 12);
    }

    public static void exampleLoot(ArrayList<String> loots){
        loots.add("gold coin");
        loots.add("dagger");
        loots.add("gold coin");
        loots.add("gold coin");
        loots.add("ruby");
    }

    public static void displayInventory(LinkedHashMap<String, Integer> inv) {
        int total = 0;
        for (HashMap.Entry<String,Integer> entry : inv.entrySet()) {
        String key = entry.getKey();
        int value = entry.getValue();
        total += value;

        System.out.println(value + " " + key);
        }
        System.out.println("Total number of items: " + total);
    }

    public static LinkedHashMap<String,Integer> addToInventory(LinkedHashMap<String, Integer> inv, ArrayList<String> loots) {
        for (String loot : loots) {
            inv.merge(loot, 1, Integer::sum);
        }
        return inv;
    }

    public static int longestItem(HashMap<String, Integer> inv, String type){
        int max = 0;
        switch (type) {
            case "key":
                for (String key : inv.keySet()) {
                    if (key.length() > max) {
                    max = key.length();
                    }}
                break;
            case "value":
                Integer maxVal = Integer.toString(Collections.max(inv.values())).length();
                if (maxVal < "count".length()) {
                    max = "count".length();
                }
                break;

        }
        return max;
    }

    public static void printTable(HashMap<String, Integer> inv) {
        String heading1 = "count";
        String heading2 = "item name";
        System.out.println("Inventory:");

        int maxLengthKey = GameInventory.longestItem(inv, "key");
        int maxLengthValue = GameInventory.longestItem(inv, "value");
        int total = 0;
        Integer n1;
        Integer n2;
        String s = " ";
        String d = "-";
        String divider = new String(new char[maxLengthKey+maxLengthValue+4]).replace("\0", d);
        String paddingCount = new String(new char[maxLengthValue-heading1.length()]).replace("\0", s);
        String paddingItemName = new String(new char[maxLengthKey-heading2.length()]).replace("\0", s);
        System.out.print(paddingCount + heading1 +"    ");
        System.out.println(paddingItemName +heading2);
        System.out.println(divider);
        for (HashMap.Entry<String,Integer> entry : inv.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            total += value;
            n1 = maxLengthKey - key.length() + 2;
            n2 = maxLengthValue - Integer.toString(value).length();
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

