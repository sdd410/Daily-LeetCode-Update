/*
* 81. Search in Rotated Sorted Array II

Given a rotated sorted array nums (may contain duplicates) and an integer target, return true if target is in nums, else false.

Example:
Input: nums = [2,5,6,0,0,1,2], target = 0 → Output: true
Input: nums = [2,5,6,0,0,1,2], target = 3 → Output: false*/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}