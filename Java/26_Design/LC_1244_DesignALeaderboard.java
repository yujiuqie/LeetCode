class Leaderboard {

    class ListNode {
        ListNode prev;
        ListNode next;// 双链表，一个前，一个后
        int value = 0;

        public ListNode(int value) {
            this.value = value;// 初始化
        }
    }

    HashMap<Integer, ListNode> map;// 哈希表
    ListNode head = new ListNode(1000001);
    ListNode tail = new ListNode(0); // 链表

    public Leaderboard() {
        this.map = new HashMap<>();// 构造
        head.next = tail;
        tail.prev = head;// 双链表链接
    }

    public void addScore(int playerId, int score) {
        ListNode cur = new ListNode(0); // 链表
        if (map.containsKey(playerId)) {
            // 如果当前节点已经存在，则需要先断开节点
            cur = map.get(playerId);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        cur.value += score;
        map.put(playerId, cur);// 保存哈希表
        insert(cur);// 插入
    }

    public int top(int K) {
        ListNode cur = head.next;
        int result = 0;
        while (K > 0) {
            result += cur.value;
            cur = cur.next;// 继续下一个

            K -= 1;
        }

        return result;// 结果
    }

    public void reset(int playerId) {
        ListNode cur = map.get(playerId);// 获取
        map.remove(playerId);// 删除

        // 断开节点
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

    }

    public void insert(ListNode node) {
        ListNode cur = head;
        while (node.value < cur.value) {
            cur = cur.next;// 循环最后
        }

        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
        node.prev.next = node;// 插入
    }
}

public class LC_1244_DesignALeaderboard {

}
