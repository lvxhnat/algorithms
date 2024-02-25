class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # Squared values will always be positive
        l_pointer, r_pointer = 0, len(nums) - 1
        
        l = [0] * len(nums) # To prevent append time complexities
        
        for i in range(len(nums)):
            
            if (abs(nums[l_pointer]) > abs(nums[r_pointer])):
                
                l[len(nums) - 1 - i] = nums[l_pointer] ** 2
                
                l_pointer += 1
                
            else: 
                
                l[len(nums) - 1 - i] = nums[r_pointer] ** 2
                
                r_pointer -= 1
        
        return l
