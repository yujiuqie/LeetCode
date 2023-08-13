import Cocoa

var node : TreeNode = TreeNode(5)
node.left = TreeNode(1)
node.left?.left = TreeNode(5)
node.left?.right = TreeNode(5)

node.right = TreeNode(5)
node.right?.right = TreeNode(5)

let solution_549 = LC_549_BinaryTreeLongestConsecutiveSequenceII()
solution_549.longestConsecutive(node)

let solution_250 = LC_250_CountUnivalueSubtrees()
solution_250.countUnivalSubtrees(node)
