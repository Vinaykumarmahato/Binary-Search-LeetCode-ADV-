public class Solution5 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        int left = 0, right = nums.length - 1;

        // Find first occurrence of target
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        } else {
            return result;
        }

        // Find last occurrence of target
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        result[1] = right;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Search range for target " + target1 + " in nums1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Search range for target " + target2 + " in nums2: [" + result2[0] + ", " + result2[1] + "]");
    }
}
