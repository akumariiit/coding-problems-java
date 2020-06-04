package com.dogacoder.www.leetcode.june2020;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 *
 * Note:
 *
 *     1 <= costs.length <= 100
 *     It is guaranteed that costs.length is even.
 *     1 <= costs[i][0], costs[i][1] <= 1000
 */
public class CityScheduling_3 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        int sum = 0;

        for (int i = 0; i < costs.length; i++) {
            System.out.println(costs[i][0] + " and " + costs[i][1]);
            if (i < costs.length/2) {
                sum += costs[i][0];
            }
            else {
                sum += costs[i][1];
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int a[][] = {{10,20},{30,200},{400,50},{30,20}};
        assertEquals(twoCitySchedCost(a), 110);
    }
}
