import java.util.HashMap;

class Solution_Failure {

    public static boolean checkInclusion(String s1, String s2) {
        // AB EIDBAOOO TRUE
        // HELLO OOOOOEHHEOOLLLO FALSE
        // AB EIDBOOAO FALSE
        // ADC DCDA
        HashMap<Character, Integer> s1_map = new HashMap<>();

        // Add our hashmaps to a template one
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            addInitialiseMap(s1_map, c);
        }

        // Maintain our own s2 hashmap as well
        HashMap<Character, Integer> s2_map = new HashMap<>();
        // Maintain an accumulator to see how many consecutive characters we have got
        int consecutiveHits = 0;

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            // Now we check and add
            if (s1_map.containsKey(c)) {
                // If the s1 map contains the char key, we need to
                // 1. Add in to our s2 hashmap
                // 2. Make sure that it does not contain more than the stipulated amount of
                // chars
                addInitialiseMap(s2_map, c);
                consecutiveHits++;
                if (s2_map.get(c) > s1_map.get(c)) {
                    // It has exceeded our limit, so we refresh hashmap
                    s2_map = new HashMap<>();
                    s2_map.put(c, 1);
                    consecutiveHits = 1;
                }
            } else {
                // The chain has been broken, so we refresh our s2_map
                s2_map = new HashMap<>();
                consecutiveHits = 0;
            }

            if (consecutiveHits == s1.length()) {
                return true;
            }

            System.out.println(consecutiveHits + " " + c);
        }

        return false;

    }

    public static void addInitialiseMap(HashMap<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("adc", "dcddddcda"));
    }
}
