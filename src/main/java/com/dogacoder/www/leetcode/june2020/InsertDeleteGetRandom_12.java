package com.dogacoder.www.leetcode.june2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_12 {

    Map<Integer, Integer> valueIndexMap;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom_12() {
        valueIndexMap = new HashMap();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        valueIndexMap.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }
        int currIndex = valueIndexMap.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(currIndex, lastVal);
        valueIndexMap.put(lastVal, currIndex);
        list.remove(list.size()-1);
        valueIndexMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
