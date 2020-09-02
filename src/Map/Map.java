package Map;

public interface Map<K, V> {

    void add(K key, V val);

    void set(K key, V val);

    V remove(K key);

    V get(K key);

    boolean isEmpty();

    boolean contains(K key);

    int getSize();

}
