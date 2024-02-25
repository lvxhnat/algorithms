# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        si, s, fi = 0,head,0
        
        while head is not None: 
            head = head.next
            fi += 1
            
            if (si < fi // 2):
                s = s.next
                
            si = fi//2
            
        return s
