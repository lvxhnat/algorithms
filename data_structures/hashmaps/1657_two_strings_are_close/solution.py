from collections import Counter


class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        freq_1 = Counter(word1)
        freq_2 = Counter(word2)
        a = Counter(freq_1.values())
        b = Counter(freq_2.values())
        c = b - a
        return freq_1.keys() == freq_2.keys() and len(c) == 0


if __name__ == "__main__":
    word1 = "abc"
    word2 = "bca"
    print(Solution().closeStrings(word1, word2))
