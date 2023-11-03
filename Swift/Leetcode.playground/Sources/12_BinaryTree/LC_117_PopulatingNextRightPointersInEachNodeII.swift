class Solution {
    func connect(_ root: Node?) -> Node? {
        guard let root = root else {
            return nil
        }
        var queue = [Node]()
        queue.append(root)
        while !queue.isEmpty {
            let size = queue.count
            var pre: Node? = nil
            for i in 0..<size {
                let node = queue.removeFirst()
                if i < size - 1 {
                    node.next = queue.first
                }
                if let left = node.left {
                    queue.append(left)
                }
                if let right = node.right {
                    queue.append(right)
                }
            }
        }
        return root
    }
}