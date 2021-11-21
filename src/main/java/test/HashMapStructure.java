package test;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapStructure {
    public static void main(String[] args) {
        Country india = new Country("India", 1000);
        Country japan = new Country("Japan", 10000);
        Country france = new Country("France", 2000);
        Country russia = new Country("Russia", 20000);

        HashMap<Country, String> map = new HashMap<Country, String>();
        map.put(india, "Delhi");
        map.put(japan, "Tokyo");
        map.put(france, "Paris");
        map.put(russia, "Moscow");

        Iterator<Country> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Country obj = iterator.next();
            String capital = map.get(obj);
            System.out.println(obj.getName() + " " + capital);
        }
    }
}
