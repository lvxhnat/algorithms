class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        ## We can maintain two pointers here, a fast and slow pointer 
        ## Start both pointers at 0
        
        slow = 0
        
        for fast in range(len(nums)): # The faster pointer will iterate over the nums 
            # Fast pointer will be the index dedicated for replacement
            # Slow pointer will be the index that contains the 0
            if nums[fast] != 0 and nums[slow] == 0:
                nums[fast], nums[slow] = nums[slow], nums[fast] # Python Swap trick 
            
            if nums[slow] != 0: # This line works because the number of elements == 0 can never be more than half the length of the list!
                slow += 1
        
        return nums
        
        
