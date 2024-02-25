from typing import List


class Solution:

    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:

        nums1 = set(nums1)
        nums2 = set(nums2)
        output = []
        output.append([*(nums1 - nums2)])
        output.append([*(nums2 - nums1)])
        return output


if __name__ == "__main__":
    s = Solution().findDifference([1, 1, 1], [2, 1, 1])
    print(s)
