import java.util.*;

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

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution_1490_1 {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node nRoot = new Node(root.val);

        for (Node subNode : root.children) {
            nRoot.children.add(cloneTree(subNode));
        }

        return nRoot;
    }
}

class Solution_1490_2 {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node nRoot = new Node(root.val);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Queue<Node> nQueue = new LinkedList<>();
        nQueue.offer(nRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                Node nNode = nQueue.poll();

                for (Node subNode : node.children) {
                    Node nSubNode = new Node(subNode.val);
                    nNode.children.add(nSubNode);

                    queue.offer(subNode);
                    nQueue.offer(nSubNode);
                }
            }
        }

        return nRoot;
    }
}