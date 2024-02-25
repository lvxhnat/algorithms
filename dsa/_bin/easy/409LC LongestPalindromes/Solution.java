import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {

        if (s.length() == 1)
            return 1;

        HashMap<Character, Integer> accumulator = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (accumulator.containsKey(c))
                accumulator.put(c, accumulator.get(c) + 1);
            else
                accumulator.put(c, 1);
        }

        int total = 0;
        int maxOdd = 0;

        for (char key : accumulator.keySet()) {
            if (accumulator.get(key) % 2 == 0)
                total += accumulator.get(key);
            else {
                maxOdd = Math.max(maxOdd, accumulator.get(key));
            }
        }

        return total + maxOdd;
    }
}
