import math
from typing import List


class Solution:

    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        min_length = math.inf
        l_pointer = 0
        current_sum = 0

        for r_pointer in range(n):
            current_sum += nums[r_pointer]
            while current_sum >= target:
                min_length = min(min_length, r_pointer - l_pointer + 1)
                current_sum -= nums[l_pointer]
                l_pointer += 1

        return 0 if min_length == math.inf else min_length


class MySolution:

    def minSubArrayLen(self, target: int, nums: List[int]) -> int:

        l_pointer, r_pointer = 0, 0  # stores the indices
        cx = nums[0]
        min_length = math.inf

        while l_pointer < r_pointer:

            if r_pointer < len(nums) - 1 and cx < target:
                r_pointer += 1
                cx += nums[r_pointer]

            if cx >= target:
                min_length = min(
                    min_length,
                    r_pointer - l_pointer + 1,
                )
                l_pointer += 1

            if cx > target or r_pointer == len(nums) - 1:
                print(l_pointer, r_pointer, cx)
                cx -= nums[l_pointer]
                l_pointer += 1

        return 0 if math.isinf(min_length) else min_length


if __name__ == "__main__":
    print(Solution().minSubArrayLen(15, [1, 2, 3, 4, 5]))
    print(Solution().minSubArrayLen(15, [5, 1, 3, 5, 10, 7, 4, 9, 2, 8]))
