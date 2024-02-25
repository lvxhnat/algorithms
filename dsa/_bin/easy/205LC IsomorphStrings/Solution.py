class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        sd, td = {}, {}
        
        if len(s) != len(t):
            return False
        
        for i in range(len(s)):
            
            if s[i] not in sd.keys():
                sd[s[i]] = i
                
            if t[i] not in td.keys():
                td[t[i]] = i
                
            if sd[s[i]] != td[t[i]]:
                return False
            
        return True
            
