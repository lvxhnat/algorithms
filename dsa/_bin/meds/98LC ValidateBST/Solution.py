from typing import Optional 
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validateBST(root.val, False, root.right) and self.validateBST(root.val, True, root.left)

    def validateBST(self, prev_val: int, isLeft: bool, root: Optional[TreeNode]):
        if root == None:
            return True
        if (prev_val > root.val and isLeft) or (not isLeft and prev_val < root.val):
            return self.validateBST(root.val, True, root.left) and self.validateBST(root.val, False, root.right)
        else:
            return False
    
    def isValidBST2(self, root, s=-inf, e=inf):
        if not root: return True
        if not s < root.val < e: return False
        return self.isValidBST(root.left, s, root.val) and self.isValidBST(root.right, root.val, e)

if __name__ == '__main__':
    s = Solution()
    node = TreeNode(2)
    node.left = TreeNode(1)
    node.right = TreeNode(3)
    print(s.isValidBST(node))
    node = TreeNode(5)
    node.left = TreeNode(1) 
    node.right = TreeNode(4)
    node.right.right = TreeNode(3)
    node.right.left = TreeNode(6)
    print(s.isValidBST(node))
