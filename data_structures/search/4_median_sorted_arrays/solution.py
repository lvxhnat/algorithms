from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        pass


class MySolution:
    """LC Hard"""

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len_nums1, len_nums2 = len(nums1), len(nums2)
        # If odd, this is the exact index, else even will plus the next index
        len_sums = len_nums1 + len_nums2
        mid = (
            len_sums // 2
        )  # We take the last element. If even, we will take the n - 1 el
        is_even = len_sums % 2 == 0
        # [1,2,3,3,10]
        # [1,3,4,5,6]
        # A possible case will be this, in which [1,2,3,3,3,4,5,6,10]

        # We want to do the algorithm in O(log(m+n)) hence we cannot use loops to recreate, since that will take linear time O(m+n)

        # Handle fully sorted and sequential arrays
        if nums1[-1] <= nums2[0]:
            if not is_even:
                return nums1[mid] if len_nums1 - 1 <= mid else nums2[mid]
            else:
                # It can be the case both mids lie on one arr, or one on each arr, or one on both arr
                if len_nums1 - 1 <= mid:
                    return (nums1[mid] + nums1[mid - 1]) / 2  # Case 1
                elif len_nums1 - 1 == mid - 1:
                    return nums1[mid - 1] + nums2[mid]  # Case 2
                else:
                    (nums2[mid - len_nums1 - 1] + nums2[mid - len_nums1]) / 2
        else:
            # Now this is the complciated case, where the last element might not be the same
            c = 0
            return


class SampleSolution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        x, y = len(nums1), len(nums2)
        low, high = 0, x

        while low <= high:
            partitionX = (low + high) // 2
            partitionY = (x + y + 1) // 2 - partitionX

            # If partitionX is 0 it means nothing is there on left side. Use -inf for maxLeftX
            # If partitionX is length of input then there is nothing on right side. Use +inf for minRightX
            maxLeftX = float("-inf") if partitionX == 0 else nums1[partitionX - 1]
            minRightX = float("inf") if partitionX == x else nums1[partitionX]

            maxLeftY = float("-inf") if partitionY == 0 else nums2[partitionY - 1]
            minRightY = float("inf") if partitionY == y else nums2[partitionY]

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                # We have partitioned array at correct place
                # Now get max of left elements and min of right elements to get the median in case of even length combined array size
                # or get max of left for odd length combined array size.
                if (x + y) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return max(maxLeftX, maxLeftY)
            elif (
                maxLeftX > minRightY
            ):  # we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1
            else:  # we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1

        # Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        raise ValueError("Input arrays are not sorted.")
