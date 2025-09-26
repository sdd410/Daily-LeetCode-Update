/*
* 704. Binary Search

Given a sorted array nums and an integer target, return its index if found, else -1.
Must run in O(log n).

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9 → Output: 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2 → Output: -1*/

class Solution {

//    private int findTarget(int[] nums, int target, int left, int right) {
//        if (left > right) {
//            return -1;
//        }
//        int mid = (left + right) / 2;
//        if (nums[mid] == target) {
//            return mid;
//        } else if (nums[mid] > target) {
//            return findTarget(nums, target, left, mid - 1);
//        } else {
//            return findTarget(nums, target, mid + 1, right);
//        }
//    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid -1;
            else left = mid +1;
        }
        return -1;

    }
}