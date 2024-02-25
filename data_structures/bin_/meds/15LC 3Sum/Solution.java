class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int l = 0; l < nums.length - 2; l++) { // We minus 2 to accomodate the other two pointers!
            int m = l + 1; // the mid pointer starts one element ahead. Right element remains static.
            int r = nums.length - 1; // the right pointer starts at the end
            if (l > 0 && nums[l] == nums[l - 1]) continue;

            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum < 0) m++;
                else if (sum > 0) r--;
                else {
                    results.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    while (m + 1 <= r && nums[m] == nums[m + 1])          m++;
                    m++; 
                    r--;
                }
            }
            while (l + 1 < nums.length && nums[l + 1] == nums[l]) l++;
        }
        
        return results;
    }
}



