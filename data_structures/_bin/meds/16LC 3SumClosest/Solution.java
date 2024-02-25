import java.util.Arrays;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        // This algorithm will take minimally O(n^2) because we need to traverse to check all possible combinations
        
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums); // Sort array. [-4, -1, 1, 2]
        
        for (int l = 0; l < nums.length - 2; l++) {
            
            int m = l + 1;
            int r = nums.length - 1;
            
            while (m < r) {
                int sums = nums[l] + nums[m] + nums[r]; 
                // System.out.println(sums + " " + l + " " + m + " " + r + " " + Math.abs(sums - target)+ " " + min);
                if (Math.abs(sums - target) < Math.abs(min - target)) {
                    min = sums;
                    // System.out.println("Minimum: " + min);
                } 
                // If our sum is higher than the target value, we decrease our sum
                if (sums - target > 0) r--;
                else if (sums - target < 0) m++;
                else return sums;
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        int[] sample = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(sample, 1));
    }
}
