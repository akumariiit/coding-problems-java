package com.dogacoder.www.immutable.map;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqualsAndHashCode {

    class MyKey {
        int id;
        String name;

        public MyKey(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("Calling equals() for key: " + o);
            if (this == o) return true;
            if (!(o instanceof MyKey)) return false;
            MyKey mykey = (MyKey) o;
            return id == mykey.id &&
                    name.equals(mykey.name);
            // return id == mykey.id;
        }

        @Override
        public int hashCode() {
            System.out.println("Calling hashCode()");
            return id;
        }

        @Override
        public String toString() {
            return "Mykey{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testEqualsHashCode() {

        HashMap<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");
        MyKey k4 = new MyKey(2, "forthKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");
        System.out.println("storing value for k4");
        map.put(k4, "forthValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);
        System.out.println("retrieving value for k4");
        String v4 = map.get(k4);

        assertEquals("firstValue", v1);
        assertEquals("secondValue", v2);
        assertEquals("thirdValue", v3);
        assertEquals("forthValue", v4);

    }
}
