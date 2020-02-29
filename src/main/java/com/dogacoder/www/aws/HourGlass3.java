package com.dogacoder.www.aws;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HourGlass3 {
    @Test
    public void test2() {
        int t[] = {1, 0, 0, 0, 2, 0, 3, 0, 4, 0 ,4,10,0,11,8,14};
        int ans = solution(t);
        System.out.println(ans);
    }

    public int solution(int[] T) {
        if(T.length == 0) {
            return 0;
        }

        List<List<Integer>> childCities = new ArrayList<>();
        for(int i = 0; i < T.length; i++) {
            childCities.add(new ArrayList<>());
        }

        for(int i = 1; i < T.length; i++) {
            int parent = T[i];
            childCities.get(parent).add(i);
        }

        // DFS
        int visited[] = new int[T.length];
        visited[0] = 1;
        for(int i = 1; i < T.length; i++) {
            visited[i] = 0;
        }

        return solve(0, visited, childCities, false);
    }

    private int solve(int start, int[] visited, List<List<Integer>> childCities, boolean oddCityVisited) {
        List<Integer> cities = childCities.get(start);
        int childAns = 0;
        for(Integer city: cities) {
            if(visited[city] != 1 && !(city%2 ==1 && oddCityVisited)) {
                visited[city] = 1;
                childAns = Math.max(childAns, solve(city, visited, childCities, (oddCityVisited || (city%2 == 1))));
                visited[city] = 0;
            }
        }
        return childAns + 1;
    }
}
