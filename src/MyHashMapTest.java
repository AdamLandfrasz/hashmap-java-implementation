import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    static MyHashMap map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap();
    }

    @Test
    void put() {
        map.put("One", 1);
        map.put("Two", 2);
        Assertions.assertNotNull(map.get("Two"));
    }

    @Test
    void update() {
        map.put("One", 1);
        map.put("One", 2);
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(2, map.get("One"));
    }

    @Test
    void get() {
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        Assertions.assertEquals(5, map.get("Five"));
    }

    @Test
    void getNonExistent() {
        map.put("One", 1);
        Assertions.assertNull(map.get("Two"));
    }

    @Test
    void contains() {
        map.put("One", 1);
        Assertions.assertTrue(map.contains("One"));
    }

    @Test
    void doesntContain() {
        Assertions.assertFalse(map.contains("One"));
    }

    @Test
    void size() {
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        Assertions.assertEquals(4, map.size());
    }

    @Test
    void nullKey() {
        map.put(null, 42);
        Assertions.assertEquals(42, map.get(null));
    }
}