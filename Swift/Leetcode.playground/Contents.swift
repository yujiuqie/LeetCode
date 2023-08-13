import Cocoa

var greeting = "Hello, playground"

var node : TreeNode = TreeNode(1)
node.left = TreeNode(2)
node.right = TreeNode(3)

let solution = LC_549_BinaryTreeLongestConsecutiveSequenceII()
solution.longestConsecutive(node)
