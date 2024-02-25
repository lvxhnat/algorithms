class Solution:
    
    def __init__(self, ): 
        self.memo = {}
        
    def memoize(self, func):
        def wrapper(n):
            if n not in self.memo:
                self.memo[n] = func(n)
            return self.memo[n]
        return wrapper
    
    @memoize
    def climbStairs(self, n: int) -> int:
        '''
        1 Step = 1
        
        2 Steps = 2
        
        3 Steps = 3
        1+1+1
        1+2
        2+1
        
        4 Steps = 5
        1+1+1+1
        1+1+2
        1+2+1
        2+1+1
        2+2
        
        Hence, step 4 -> F_n = F_(n-1) + F_(n-2)
        '''
        if n == 1: return 1 
        if n == 2: return 2 
        else: return self.climbStairs(n - 1) + self.climbStairs(n - 2)
        
