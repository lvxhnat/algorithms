class Solution:
    # This can be achieved with a queue as well though
    def maximumOddBinaryNumber(self, s: str) -> str:
        head = ""
        mid = ""
        tail = ""
        for c in s:
            if c == "1":
                if len(tail) == 0 or tail[-1] != "1":
                    tail += c
                    continue
                else: 
                    head += c
            else: 
                mid += c
        return head + mid + tail
    
if __name__ == '__main__':
    print(Solution().maximumOddBinaryNumber("100"))