package com.dogacoder.www.hackerrank.booking;

import java.util.*;

public class Result3 {

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        TreeMap<HotelScore, Integer> scoreMap = new TreeMap<>();
        List<String> positives = Arrays.asList(positiveKeywords.split(" "));
        List<String> negatives = Arrays.asList(negativeKeywords.split(" "));

        Map<String, String> positiveKeywordMap = new HashMap<>();
        Map<String, String> negativeKeywordMap = new HashMap<>();

        // some pre processing for saving time

        positives.forEach(keyword -> {
            positiveKeywordMap.putIfAbsent(keyword, keyword);
        });
        negatives.forEach(keyword -> {
            negativeKeywordMap.putIfAbsent(keyword, keyword);
        });

        for (int i = 0; i < reviews.size(); i++) {
            int score = getScoreForReview(reviews.get(i), positiveKeywordMap, negativeKeywordMap);
            scoreMap.put(hotelIds.get(i), scoreMap.getOrDefault(hotelIds.get(i),0) + score);
        }

        System.out.println(scoreMap.size());
        List<Integer> result = new ArrayList<>();
        if (k > scoreMap.size()) {
            for (Integer key: scoreMap.keySet()) {
                result.add(key);
            }
        }
        return result;
    }

    static class HotelScore {
        int hotelId;
        int score;

        public HotelScore(int hotelId, int score) {
            this.hotelId = hotelId;
            this.score = score;
        }

        public int getHotelId() {
            return hotelId;
        }

        public void setHotelId(int hotelId) {
            this.hotelId = hotelId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HotelScore)) return false;
            HotelScore that = (HotelScore) o;
            return getScore() == that.getScore();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getScore());
        }
    }

    private static int getScoreForReview(String review, Map<String, String> positiveKeywordMap, Map<String, String> negativeKeywordMap) {
        int score = 0;
        List<String> words = Arrays.asList(review.split(" "));
        for (String word: words) {
            word = word.replaceAll(".", "").replaceAll(",", "");
            if (positiveKeywordMap.get(word) != null) {
                score += 3;
            }
            if (negativeKeywordMap.get(word) != null) {
                score -= 1;
            }
        }
        return score;
    }
}
