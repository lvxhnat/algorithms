# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        prev = None # The first previous value will be pointing to None
        
        while head: 
            
            curr = head # Refers to Node 1
            head = head.next # Now this is a different object, Refers to Node 2
            curr.next = prev # Node 1 now points to None
            prev = curr # We move the previous object forward, so prev is now Node 1 
            
        return prev # This will end at Node 5, not Node 4!
