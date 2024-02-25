from typing import List


class Solution:

    def uniqueOccurrences(self, arr: List[int]) -> bool:

        arr_len: int = len(arr)
        accumulator = {}

        if arr_len % 2 != 0:
            mid_index = arr_len // 2
            # Important to know that to get the middle of the array, you do // 2
            accumulator[arr[mid_index]] = 1

        for i in range(arr_len // 2):
            val_a = arr[arr_len - 1 - i]
            val_b = arr[i]
            accumulator[val_a] = accumulator[val_a] + 1 if val_a in accumulator else 1
            accumulator[val_b] = accumulator[val_b] + 1 if val_b in accumulator else 1

        return len(set(accumulator.values())) == len(accumulator)


if __name__ == "__main__":
    test_case_1 = [1, 2, 2, 1, 1, 3]
    test_case_2 = [1, 2]
    test_case_3 = [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]
    test_case_4 = [-12, 9, 9, 10, -12, 5, 9, 9, -3, -3, -3, 9, 5, -3, -12]
    test_case_5 = [16, 16, 10, 12, 10, 13, -1, -1, 10, 12, 12, -1, 12, 10, 10]
    print(Solution().uniqueOccurrences(test_case_1))
    print(Solution().uniqueOccurrences(test_case_2))
    print(Solution().uniqueOccurrences(test_case_3))
    print(Solution().uniqueOccurrences(test_case_4))
    print(Solution().uniqueOccurrences(test_case_5))
