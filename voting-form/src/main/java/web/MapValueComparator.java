package web;

import java.util.Comparator;
import java.util.Map;

public class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

    /**
     *
     * @param me1 the first object to be compared.
     * @param me2 the second object to be compared.
     * @return
     */
    public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {
        return me2.getValue().compareTo(me1.getValue());
    }

}
