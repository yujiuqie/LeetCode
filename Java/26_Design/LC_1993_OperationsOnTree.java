class LockingTree {

    private int[] locked;
    private int[] parent;
    private Map<Integer, List<Integer>> children;

    public LockingTree(int[] parent) {
        int n = parent.length;
        locked = new int[n];
        this.parent = parent;
        children = new HashMap<>();
        Arrays.fill(locked, -1);

        for (int i = 0; i < n; i++) {
            children.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] == -1) {
            locked[num] = user;
            return true;
        }

        return false;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] == user) {
            locked[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        int x = num;

        // 首先判断节点 num 及其祖先节点是否被上锁，如果是，则返回 false
        while (x != -1) {
            if (locked[x] != -1) {
                return false;
            }
            x = parent[x];
        }

        // 判断节点 num 的子孙节点是否有被上锁的，如果没有，则返回 false
        boolean[] find = new boolean[1];
        dfs(num, find);
        if (!find[0]) {
            return false;
        }

        locked[num] = user;
        return true;
    }

    private void dfs(int x, boolean[] find) {
        for (int y : children.get(x)) {
            if (locked[y] != -1) {
                locked[y] = -1;
                find[0] = true;
            }
            dfs(y, find);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */

public class LC_1993_OperationsOnTree {

}
