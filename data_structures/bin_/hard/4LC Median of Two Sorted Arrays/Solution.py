from typing import List 
import math 

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        length = len(nums1) + len(nums2)
        mid = math.ceil(length / 2) - 1 # Get the median index that we require. 

        i_1, i_2 = 0, 0 # The starting indexes we want to parse for both lists
        
        # Get average if the length % 2 == 0, i.e. mid + (mid + 1) / 2
        for index in range(length): # Max we iterate through every element in the list
           
            if index == mid + 1: 
                if length % 2 == 0: 
                    return current_value
                else: 
                    if nums1[i_1] > nums2[i_2]:
                        return (current_value + nums2[i_2])/2
                    else: 
                        return (current_value + nums1[i_1])/2
            
            if i_1 == len(nums1):
                return nums2[mid - i_1]
            
            if i_2 == len(nums2): 
                return nums1[mid - i_2]

            # Offset by 1 
            if nums1[i_1] > nums2[i_2]: 
                current_value = nums2[i_2] 
                i_2 += 1
            else: 
                current_value = nums1[i_1]
                i_1 += 1 
                
if __name__ == '__main__':
    solution = Solution() 
    print(solution.findMedianSortedArrays([1,2], [3,4]))
    print(solution.findMedianSortedArrays([1,3], [2]))

