class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        maxPrice = 0
        cumSum = 0 
        
        for i in range(1, len(prices)):
            cumSum = max(0, cumSum + prices[i] - prices[i-1])
            maxPrice = max(cumSum, maxPrice)
        
        return maxPrice
