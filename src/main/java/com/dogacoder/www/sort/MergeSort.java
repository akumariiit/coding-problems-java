package com.dogacoder.www.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    private static void printArray(int A[])
    {
        int i;
        for (i=0; i < A.length; i++)
            System.out.println(A[i]);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right-left+1];
        int resIndex = 0;
        int leftPointer = left;
        int rightPointer = mid+1;
        while (leftPointer <= mid && rightPointer <= right) {
            if (arr[leftPointer] <= arr[rightPointer]) {
                res[resIndex++] = arr[leftPointer++];
            }
            else {
                res[resIndex++] = arr[rightPointer++];
            }
        }
        if (leftPointer < mid) {
            for (int i = leftPointer; i <= mid; i++) {
                res[resIndex++] = arr[i];
            }
        }
        if (rightPointer < right) {
            for (int i = rightPointer; i <= right; i++) {
                res[resIndex++] = arr[i];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = res[i];
        }
    }

    private void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
