import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            return memo.get(n);
        }
    }
}