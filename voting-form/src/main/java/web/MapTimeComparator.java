package web;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Map;

public class MapTimeComparator implements Comparator<Map.Entry<Timestamp, String>> {

    /**
     *
     * @param me1 the first object to be compared.
     * @param me2 the second object to be compared.
     * @return
     */
    public int compare(Map.Entry<Timestamp, String> me1, Map.Entry<Timestamp, String> me2) {
        return me2.getKey().compareTo(me1.getKey());
    }
}
