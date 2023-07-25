import java.util.*;

public class Solution6 {
    private static final Solution6 Solution6 = null;

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            result[i] = key != null ? map.get(key) : -1;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        int[][] intervals = {{1, 3}, {2, 4}, {5, 6}, {7, 8}};
        int[] result = ((Solution6) Solution6).findRightInterval(intervals);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
