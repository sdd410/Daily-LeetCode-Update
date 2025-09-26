/*153. Find Minimum in Rotated Sorted Array

Given a rotated sorted array nums (unique elements), return the minimum element.
Must run in O(log n).

Example 1:
Input: [3,4,5,1,2] → Output: 1

Example 2:
Input: [4,5,6,7,0,1,2] → Output: 0

Example 3:
Input: [11,13,15,17] → Output: 11*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}