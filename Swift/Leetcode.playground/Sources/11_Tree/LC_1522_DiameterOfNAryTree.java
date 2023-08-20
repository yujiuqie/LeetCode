/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int max = 0;

    public int diameter(Node root) {
        height(root);
        return max;
    }

    private int height(Node node){
        if(node.children.size() == 0){
            return 0;
        }

        int maxHeight_1 = 0;
        int maxHeight_2 = 0;
        for(Node child : node.children){
            int parentHeight = height(child) + 1;
            if(parentHeight > maxHeight_1){
                maxHeight_2 = maxHeight_1;
                maxHeight_1 = parentHeight;
            }
            else if(parentHeight > maxHeight_2){
                maxHeight_2 = parentHeight;
            }

            int dis = maxHeight_1 + maxHeight_2;
            max = Math.max(max,dis);
        }
        return maxHeight_1;
    }
}

public class LC_1522_DiameterOfNAryTree {
    
}
