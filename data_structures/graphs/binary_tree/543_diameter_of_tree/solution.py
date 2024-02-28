## Our current implementation calculates the diameter as if it must go through the root, by summing the maximum depths of the left and right subtrees of the root node.
## This is why your solution might fail for some test cases, especially those where the longest path exists entirely within a left or right subtree.

from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class OriginalSolution:
    def parseSideTree(self, root):
        if root is None:
            return 0
        return 1 + max(self.parseSideTree(root.left), self.parseSideTree(root.right))

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        return self.parseSideTree(root.left) + self.parseSideTree(root.right)


class SolutionRecurse:
    def __init__(self):
        self.diameter = 0  # Global variable to keep track of the diameter

    def depth(self, node):
        if not node:
            return 0
        # Recursively find the maximum depth of left and right subtrees
        left_depth = self.depth(node.left)
        right_depth = self.depth(node.right)

        # Update the diameter if this node's path is longer than the current diameter
        self.diameter = max(self.diameter, left_depth + right_depth)

        # Return the depth of the tree rooted at this node
        return 1 + max(left_depth, right_depth)

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.depth(root)  # Initialize the depth calculation and diameter update
        return self.diameter


class SolutionIterative:
    def __init__(self):
        pass
