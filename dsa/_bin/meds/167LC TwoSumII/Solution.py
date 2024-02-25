class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        """
        [2, 3, 4] 6 
        2 2 = 4
        2 3 = 5
        2 4 = 6
        
        [1, 3, 6, 7, 10] 23
        1 1 = 2
        1 3 = 4
        1 3 6 = 10 
        1 3 6 7 = 17
        
        
        """
        slow, fast = 0, len(numbers) - 1
        
        while (slow < fast):
            
            sums = numbers[slow] + numbers[fast]
            
            if sums == target:
                
                break
            
            elif sums > target:
                
                fast -= 1
                
            else:
                
                slow += 1
                
        return [slow + 1, fast + 1]
