class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        """
        [ 1 3 5 6 ]  7 
        l = 0 r = 3 m = 1 + 1 (3)
        m_v = 5 < 7 
        l = 2 r = 3 m = 2 + 1 (3)
        m_v = 6 < 7 
        """
        l, r = 0, len(nums) - 1
        
        while (l <= r):
            
            mid = int((l + r) / 2 )
            
            if target == nums[mid]:
                return mid 
            
            if nums[mid] < target:
                l = mid  + 1
            else:
                r = mid - 1
                
        return l 
