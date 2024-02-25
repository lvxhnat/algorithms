class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        
        counter = 0
        
        if len(s) == 0:
            return True
        
        for i in range(len(t)):
            if s[counter] == t[i]:
                if counter == len(s) - 1:
                    return True 
                counter += 1
                
        return False
