# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        nodes = [root]
        traversed = []
        
        if root == None: 
            return traversed
        
        while (nodes):
            traversed.append([node.val for node in nodes if node])
            d = []
            for node in nodes:
                if node:
                    if node.left: 
                        d.append(node.left)
                    if node.right: 
                        d.append(node.right)
            nodes = d 
        
        return traversed
