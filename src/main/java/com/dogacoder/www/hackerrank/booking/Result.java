package com.dogacoder.www.hackerrank.booking;

import java.util.HashMap;
import java.util.Map;

class Result {

    /*
     * Complete the 'maximumOccurringCharacter' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts STRING text as parameter.
     */

    public static char maximumOccurringCharacter(String text) {
        char result = Character.MIN_VALUE;
        int maxCount = 0;
        // Write your code here
        Map<Character, Count> countMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if (countMap.get(c) == null) {
                Count count = new Count(i, 1);
                countMap.putIfAbsent(c, count);
            } else {
                Count count = countMap.get(c);
                count.setCount(count.getCount()+1);
            }
            if (countMap.get(c).getCount() > maxCount) {
                maxCount = countMap.get(c).getCount();
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Count> entry : countMap.entrySet()) {
            if (entry.getValue().getCount() == maxCount && entry.getValue().getFirstIndex() < minIndex) {
                result = entry.getKey();
                minIndex = entry.getValue().getFirstIndex();
            }
        }

        return result;

    }

    static class Count {
        int firstIndex;
        int count;

        public Count(int firstIndex, int count) {
            this.firstIndex = firstIndex;
            this.count = count;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public void setFirstIndex(int firstIndex) {
            this.firstIndex = firstIndex;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
