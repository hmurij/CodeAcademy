package lt.codeacademy.model;

import java.util.ArrayList;
import java.util.List;

public class Map <K, V> {

    private final List<Pair<K, V>> pairs;

    public Map() {
        this.pairs = new ArrayList<>()  ;
    }

    public void addPair(K key, V value) {
        pairs.add(new Pair<>(key, value));
    }

    public V getPairValue(K key) {
        V value = null;

        for (var pair : pairs) {
            if (pair.getKey().equals(key)) {
                value = pair.getValue();
                break;
            }
        }

        return value;
    }

}
