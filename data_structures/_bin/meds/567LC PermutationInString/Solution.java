import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Perform a sliding window algorithm
        // 1. Create a hash map to store the values of the characters in s1
        // 2. We maintain two pointers, one fast one slow, both initialised at index 0
        // 3. If F not in hash map, S = F + 1.
        // 4. Every time a character moves into the sliding window, if it is in hash
        // map, we minus one. If it is not in hash map, we ignore.
        // 5. If a character moves out of the sliding window, we add one to the key
        // value
        // 6. Once the length of the consecutive ++ is == len(s1), we break and return
        // true, else false

        HashMap<Character, Integer> s1Map = new HashMap<>();
        // Initialise (1)
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            createAddMap(s1Map, c);
        }

        int slowPointer = 0;
        int consecutiveHits = 0;
        for (int i = 0; i < s2.length(); i++) {
            // Our fast pointer will be i
            char c = s2.charAt(i);
            if (s1Map.containsKey(c)) {
                s1Map.put(c, s1Map.get(c) - 1);
                consecutiveHits++;
            } else {
                s1Map.put(c, s1Map.get(c) + 1);
                slowPointer = i + 1;
            }
        }
    }

    public void createAddMap(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
    }
}

// Suggested Solution
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2)
            return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count))
            return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count))
                return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}