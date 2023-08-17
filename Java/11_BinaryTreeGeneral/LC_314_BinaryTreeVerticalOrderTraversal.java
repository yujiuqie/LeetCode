import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solutio_314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Map<Integer,List<Integer>> res = new TreeMap();
        Map<TreeNode,Integer> nodeMap = new HashMap();
        nodeMap.put(root,0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int i = nodeMap.get(node);
            res.computeIfAbsent(i,k -> new ArrayList<>()).add(node.val);
            if(node.left != null){
                queue.add(node.left);
                nodeMap.put(node.left,i - 1);
            }
            if(node.right != null){
                queue.add(node.right);
                nodeMap.put(node.right,i + 1);
            }
        }

        return new ArrayList<>(res.values());
    }
}

public class LC_314_BinaryTreeVerticalOrderTraversal {

}