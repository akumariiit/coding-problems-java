package com.dogacoder.www.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = 5;
        System.out.println(isPresent(arr, n));
    }

    private static int isPresent(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        return search(arr, n, low, high);
    }

    private static int search(int[] arr, int n, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low)/2;
        if (arr[mid] == n) {
            return mid;
        }
        if (arr[mid] > n) {
            return search(arr, n, low, mid - 1);
        }
        else {
            return search(arr, n, mid + 1, high);
        }
    }
}
