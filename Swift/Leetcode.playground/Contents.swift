import Cocoa

var node : TreeNode = TreeNode(5)
node.left = TreeNode(1)
node.left?.left = TreeNode(5)
node.left?.right = TreeNode(5)
node.right = TreeNode(5)
node.right?.right = TreeNode(5)

let solution_250 = LC_250_CountUnivalueSubtrees()
solution_250.countUnivalSubtrees(node)

let solution_549 = LC_549_BinaryTreeLongestConsecutiveSequenceII()
solution_549.longestConsecutive(node)

let solution_604 = StringIterator("L1e2t1C1o1d1e1")
solution_604.next()
solution_604.next()
solution_604.next()
solution_604.next()
solution_604.next()
solution_604.next()
solution_604.hasNext()
solution_604.next()
solution_604.hasNext()


var node1 : TreeNode = TreeNode(1)
node1.left = TreeNode(3)
node1.left?.left = TreeNode(5)
node1.right = TreeNode(2)

var node2 : TreeNode = TreeNode(2)
node2.left = TreeNode(1)
node2.left?.right = TreeNode(4)
node2.right = TreeNode(3)
node2.right?.right = TreeNode(7)

let solution_617 = LC_617_MergeTwoBinaryTrees()
solution_617.mergeTrees(node1, node2)

let solution_833 = LC_833_FindAndReplaceInString()
solution_833.findReplaceString("abcd", [0,2], ["ab","ec"], ["eee","ffff"])

let solution_1180 = LC_1180_CountSubstringsWithOnlyOneDistinctLetter()
solution_1180.countLetters("aaaba")

let solution_1120 = LC_1120_MaximumAverageSubtree()
solution_1120.maximumAverageSubtree(node1)

let solution_2682 = LC_2682_FindTheLosersOfTheCircularGame()
solution_2682.circularGameLosers(5,2)
