class Solution(object):
    def lengthOfLongestSubstring(self, s):
        l_p = 0
        char_index = {}
        max_length = 0
        for r_p in range(len(s)):
            if s[r_p] in char_index and char_index[s[r_p]] >= l_p:
                l_p = char_index[s[r_p]] + 1
            char_index[s[r_p]] = r_p
            max_length = max(max_length, (r_p - l_p) + 1)
        return max_length
