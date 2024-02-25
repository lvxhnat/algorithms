import java.util.HashMap;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // Save the character into a hashmap with integer reference
        HashMap<Character, Integer> map = new HashMap<>();
        // Iterate through the characters
        int maxLength = 0;
        int absoluteMax = 0;
        int l_pointer = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the map doesnt contain the key then we add it in
            if (!map.containsKey(c) || (map.containsKey(c) && l_pointer > map.get(c)) ) {
                System.out.println("---- maxLength: " + maxLength + " l_pointer:" + l_pointer + " i:" + i);
            } else {
                l_pointer = map.get(c) + 1;
                maxLength = i - l_pointer;
                System.out.println("maxLength: " + maxLength + " l_pointer:" + l_pointer + " i:" + i); 
            }
            map.put(c, i);
            maxLength ++;
            absoluteMax = Math.max(maxLength, absoluteMax);
        }
        return absoluteMax;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring("bbtablud"));
    }
}
