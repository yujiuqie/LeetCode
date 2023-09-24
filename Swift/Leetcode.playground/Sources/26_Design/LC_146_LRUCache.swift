class DLinkedList : NSObject {
    public var key: Int
    public var val: Int
    public var pre: DLinkedList?
    public var next: DLinkedList?
    public init(_ val: Int,_ key: Int) {
        self.val = val
        self.key = key
    }
    
    override init() {
        self.key = 0
        self.val = 0
    }
}

class LRUCache: NSObject {
    var cache = [Int : DLinkedList]()
    var capacity : Int
    var head : DLinkedList?
    var tail : DLinkedList?
    
    init(_ capacity: Int) {
        self.capacity = capacity
        self.head = DLinkedList()
        self.tail = DLinkedList()
        self.head?.next = self.tail
        self.tail?.pre = self.head
    }
    
    func get(_ key: Int) -> Int {
        guard let node = self.cache[key] else{
            return -1
        }

        self.moveToHead(node)
        return node.val 
    }
    
    func put(_ key: Int, _ value: Int) {
        guard let node = self.cache[key] else {
            let node = DLinkedList(value, key)
            self.cache[key] = node
            self.addToHead(node)
  
            if self.cache.count > self.capacity {
                let node = self.removeTail()
                self.cache.removeValue(forKey: node!.key)
            }
            return
        }

        node.val = value
        self.moveToHead(node)
    }
    
    func addToHead(_ node: DLinkedList) {
        node.pre = head
        node.next = head?.next
        head?.next?.pre = node
        head?.next = node;
    }
    
    func moveToHead(_ node: DLinkedList) {
        self.removeNode(node)
        self.addToHead(node)
    }
    
    func removeNode(_ node: DLinkedList) {
        node.pre?.next = node.next;
        node.next?.pre = node.pre;
    }
    
    func removeTail() -> DLinkedList? {
        let node = self.tail?.pre
        self.removeNode(node!)
        return node
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache(capacity)
 * let ret_1: Int = obj.get(key)
 * obj.put(key, value)
 */