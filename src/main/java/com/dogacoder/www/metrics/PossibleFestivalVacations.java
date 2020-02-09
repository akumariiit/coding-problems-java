package com.dogacoder.www.metrics;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;


/**
 *

 You want to spend your next vacation in a foreign country. In the summer you are free for N consecutive days. By a strange coincidence, in the foreign country there are N villages numbered from 0 to N−1. On each day there will be a festival in one of the villages; on day K there will be a festival in village number K.

 You plan to begin your vacation on some day A and end it on some day B (0 ≤ A ≤ B < N). During day K you will attend the festival organized in village K, and in the evening (if K < B) you will take a bus to village K+1.

 The villages are connected by N−1 bidirectional roads in such a way that there is exactly one path (not necessarily direct) between any two villages. If the path between villages K and K+1 is not direct, the bus will travel through some other village(s). Whenever you travel through a village, you are extremely sad if you did not and will not attend the festival in this village, which would totally ruin your vacations. In other words, if during travel between villages K and K+1 the bus passes through some village J, following inequalities must be satisfied: A ≤ J ≤ B.

 You are given a map of the road network in the form of array T of length N. This means that if T[K] = J and K ≠ J, then there is a direct road between villages K and J.

 Write a program that calculates how many possible vacations you can consider, i.e., how many pairs of days (A, B) satisfy the constraints that you will visit all the villages you see during your bus trips (visited villages numbers create continuous range of integers).

 Write a function:

 class Solution { public int solution(int[] T); }

 that, given a non-empty array T consisting of N integers describing a road network between N villages, returns your number of possible vacations.

 For example, the following array
 T[0] = 2
 T[1] = 0
 T[2] = 2
 T[3] = 2
 T[4] = 1
 T[5] = 0

 encodes a country of N = 6 villages depicted in the figure below:

 Drawing of the example layout

 For this array the function should return 12, since there are twelve possible vacations: (0, 0), (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (1, 1), (2, 2), (2, 3), (3, 3), (4, 4), (5, 5).

 Every pair in which A = B is a correct vacation. Pair (2, 3) is also correct, since, during the bus trip from village 2 to village 3, you do not pass through any other village.

 Pair (0, 3) is correct. Paths the bus goes through are following: (0 −> 1), (1 −> 0 −> 2), (2 −> 3). Every bus path covers villages only from the continuous range (0, 3).

 Pair (2, 4) is not correct, since, during the bus trip from village 3 to village 4, you pass through villages 0 and 1, but you do not attend festivals in these villages.

 Pair (1, 4) is not correct. You would start on day A = 1 in village 1 and finish on day B = 4 in village 4. In the first evening you would take the bus from village 1 to 2. The path of the bus would lead through village 0 (the path is 1 −> 0 −> 2), in which the festival happened on day J = 0, i.e. before day A, hence condition A ≤ J ≤ B is violated. As you will not ever visit festival in a village you pass through, you would be extremely sad. You would pass through village 0 again after the day K = 3 during travel to village B = 4.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [2..1,000];
 each element of array T is an integer within the range [0..N−1];
 there is exactly one (possibly indirect) connection between any two distinct villages.


 */
public class PossibleFestivalVacations {

    public int solution(int[] T) {
        // write your code in Java SE 8
        int size = T.length;
        int possibleVacations = size;
        Map<Integer, Set<Integer>> reachMap = populateReachmap(T);
        List<Set<Integer>> villageListPerPair = new ArrayList<>();

        for (int i = 0; i < size-1; i++) {
            Set<Integer> villageList = getVillageList(i, i+1, reachMap);
        }



        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if (canGo(i, j, reachMap)) {
                    possibleVacations++;
                }
            }
        }
        return possibleVacations;
    }

    private Set<Integer> getVillageList(int village, int nextVillage, Map<Integer, Set<Integer>> reachMap) {
        Set<Integer> villageList = new TreeSet<>();
        villageList.add(village);
        villageList.add(village);
        while (true) {
            Set<Integer> routesFromVillage = reachMap.get(village);
            if (routesFromVillage.contains(nextVillage)) {
                villageList.add(nextVillage);
                break;
            }
            for (int i = 0; i < routesFromVillage.size(); i++) {
                village = i;
            }
        }
        return villageList;
    }

    private Map<Integer, Set<Integer>> populateReachmap(int[] routes) {
        Map<Integer, Set<Integer>> reachMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            if (reachMap.get(i) == null) {
                reachMap.put(i, new TreeSet<>());
            }
            if (reachMap.get(routes[i]) == null) {
                reachMap.put(routes[i], new TreeSet<>());
            }
            reachMap.get(i).add(routes[i]);
            reachMap.get(routes[i]).add(i);
        }
        return reachMap;
    }

    private boolean canGo(int a, int b, Map<Integer, Set<Integer>> reachMap) {
        if (a==b) {
            System.out.println("Route = " + a + " -> " + b);
            return true;
        }
        final Set<Integer> reachableVillages = reachMap.get(a);
        for (int villageNumber : reachableVillages) {
            if (villageNumber > a && villageNumber < b) {
                return canGo(villageNumber, b, reachMap);
            }
        }
        return false;
    }


    @Test
    public void testShortestDistance() {
        int input[] = {5, 5, 0, 5, 5, 5};
        int answer = solution(input);
        System.out.println(answer);
        assertTrue(answer == 9);
    }
}
