
class DLinkedList {
    int key;
    int val;
    public DLinkedList pre;
    public DLinkedList next;

    public DLinkedList() {
    };

    public DLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    };
}

class LRUCache {

    DLinkedList head;
    DLinkedList tail;
    HashMap<Integer, DLinkedList> map;
    int max;
    int count;

    public LRUCache(int capacity) {
        max = capacity;
        count = 0;

        head = new DLinkedList();
        tail = new DLinkedList();

        head.next = tail;
        tail.pre = head;

        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedList node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedList node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (count == max) {
                DLinkedList lNode = removeTail();
                map.remove(lNode.key);
                count--;
            }
            DLinkedList node = new DLinkedList(key, value);
            addToHead(node);
            map.put(key, node);
            count++;
        }
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedList node) {
        DLinkedList hNext = head.next;
        node.next = hNext;
        hNext.pre = node;

        head.next = node;
        node.pre = head;
    }

    private void removeNode(DLinkedList node) {
        DLinkedList pre = node.pre;
        DLinkedList next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private DLinkedList removeTail() {
        DLinkedList node = tail.pre;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LC_146_LRUCache {

}
