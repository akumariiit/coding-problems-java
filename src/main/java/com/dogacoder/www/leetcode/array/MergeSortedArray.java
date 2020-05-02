package com.dogacoder.www.leetcode.array;

/**
 *
 * https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 *     The number of elements initialized in nums1 and nums2 are m and n respectively.
 *     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int in = m-1;
        int last = nums1.length-1;
        while (in >= 0) {
            nums1[last--] = nums1[in--];
        }
        int fIndex = nums1.length - m;
        int sIndex = 0;

        int rIndex = 0;
        while (sIndex < nums2.length && fIndex < nums1.length) {
            if (nums1[fIndex] <= nums2[sIndex]) {
                nums1[rIndex++] = nums1[fIndex++];
            }
            else {
                nums1[rIndex++] = nums2[sIndex++];
            }
        }
        if (fIndex < nums1.length) {
            while (fIndex < nums1.length) {
                nums1[rIndex++] = nums1[fIndex++];
            }
        }
        if (sIndex < nums2.length) {
            while (sIndex < nums2.length) {
                nums1[rIndex++] = nums2[sIndex++];
            }
        }
    }
}
