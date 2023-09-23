
class LockingTree {

    var locked: [Int]
    var parent: [Int]
    var children: [Int: [Int]]

    init(_ parent: [Int]) {
        let n = parent.count
        locked = Array(repeating: -1, count: n)
        self.parent = parent
        children = [Int: [Int]]()
        for i in 0..<n {
            children[i] = [Int]()
        }
        for i in 1..<n {
            children[parent[i]]?.append(i)
        }
    }
    
    func lock(_ num: Int, _ user: Int) -> Bool {
        if locked[num] == -1 {
            locked[num] = user
            return true
        }
        return false
    }
    
    func unlock(_ num: Int, _ user: Int) -> Bool {
        if locked[num] == user {
            locked[num] = -1
            return true
        }
        return false
    }
    
    func upgrade(_ num: Int, _ user: Int) -> Bool {

        //首先判断节点 num 及其祖先节点是否被上锁，如果是，则返回 false
        var x = num
        while x != -1 {
            if locked[x] != -1 {
                return false
            }
            x = parent[x]
        }
        
        //然后判断节点 num 的子孙节点是否有被上锁的，如果一个上锁的都没有，则返回 false
        var find = [false]
        dfs(x: num, find: &find)

        //如果一个上锁的子节点都没有，那就返回 false
        if !find[0] {
            return false
        }
        locked[num] = user
        return true
    }

    func dfs(x: Int, find: inout [Bool]) {
        for y in children[x] ?? [] {
            if locked[y] != -1 {
                locked[y] = -1
                find[0] = true //如果找到一个上锁的子节点并解锁，则返回 true
            }
            dfs(x: y, find: &find)
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * let obj = LockingTree(parent)
 * let ret_1: Bool = obj.lock(num, user)
 * let ret_2: Bool = obj.unlock(num, user)
 * let ret_3: Bool = obj.upgrade(num, user)
 */