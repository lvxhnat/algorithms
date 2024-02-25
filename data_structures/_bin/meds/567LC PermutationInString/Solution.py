class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        d = {}
        for char in s1:
            if char in d: 
                d[char] += 1
            else: 
                d[char] = 1
        
        d_cp = d.copy()
        l = 0
        
        for char in s2: 
            if char in d_cp:
                d_cp[char] -= 1
                l += 1
            else: 
                d_cp = d.copy()
                l = 0
            if l == len(s1):
                return True
        return l == len(s1)
       

if __name__ == '__main__': 
    s = Solution() 

    print(s.checkInclusion("ab", "eidbaooo"))
    print(s.checkInclusion("adc", "dcda"))
