class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1;
        while (left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = k - mid1;
            if (nums1[mid1] < nums2[mid2 - 1]) {
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }
        int mid1 = left;
        int mid2 = k - left;
        int c1 = Math.max(mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1], 
                          mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }
        int c2 = Math.min(mid1 >= n1 ? Integer.MAX_VALUE : nums1[mid1], 
                          mid2 >= n2 ? Integer.MAX_VALUE : nums2[mid2]);
        return (c1 + c2) * 0.5;
    }
}

public class Solution1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        
        Solution solution = new Solution();
        double median = solution.findMedianSortedArrays(nums1, nums2);
        
        System.out.println("Median: " + median);
    }
}
