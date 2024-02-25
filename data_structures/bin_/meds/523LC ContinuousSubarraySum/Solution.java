class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;
            if (map.containsKey(remainder) && i - map.get(remainder) > 1) {
                return true;
            }
            map.putIfAbsent(remainder, i);
        }
        return false;
    }
}