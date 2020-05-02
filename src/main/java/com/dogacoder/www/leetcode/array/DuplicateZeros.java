package com.dogacoder.www.leetcode.array;

/**
 *
 * https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 *
 * Note:
 *
 *     1 <= arr.length <= 10000
 *     0 <= arr[i] <= 9
 *
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int in = 0;
        while (in < arr.length-1) {
            if (arr[in] == 0) {
                for (int j=arr.length-1; j>in; j--) {
                    arr[j] = arr[j-1];
                }
                in++;
                arr[in] = 0;
            }
            in++;
        }
    }
}
