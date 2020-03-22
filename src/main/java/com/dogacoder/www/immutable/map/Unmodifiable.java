package com.dogacoder.www.immutable.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Unmodifiable {

    @DisplayName("Test MessageService.get()")
    @Test
    public void testUnmodifiable() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("1", "first");
        testMap.put("2", "second");
        // wrapper over existing modifiable maps
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(testMap);

        // adding the unmodifiableMap map throws UnsupportedOperationException
        // direct modification is not allowed
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableMap.put("3", "third"));

        // change underlying map
        testMap.put("4", "fourth");
        // adding to underlying map changes unmodifiable map
        assertEquals(unmodifiableMap.get("4"), "fourth");
    }
}
