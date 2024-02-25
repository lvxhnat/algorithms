class Solution {
    public String longestCommonPrefix(String[] strs) {
        String shortestString = strs[0];

        for (String s : strs) {
            if (shortestString.length() > s.length()) {
                shortestString = s;
            }
        }

        String commonSubString = "";

        for (int i = 0; i < shortestString.length(); i++) {
            ;
            for (String s : strs) {
                if (shortestString.charAt(i) != s.charAt(i))
                    return commonSubString;
            }
            commonSubString += shortestString.charAt(i);
        }

        return commonSubString;
    }
}