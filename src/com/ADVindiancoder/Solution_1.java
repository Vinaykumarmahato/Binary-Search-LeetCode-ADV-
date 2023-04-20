package com.ADVindiancoder;

public class Solution_1 {
    public static void main(String[] args) {
        Solution_12 solution = new Solution_12();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }
}

class Solution_12 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
