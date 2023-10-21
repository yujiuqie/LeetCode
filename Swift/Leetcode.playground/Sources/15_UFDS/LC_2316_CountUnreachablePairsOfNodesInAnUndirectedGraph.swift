class Solution {
    func countPairs(_ n: Int, _ edges: [[Int]]) -> Int {
        var uf = UnionFind(n)
        for edge in edges {
            let x = edge[0], y = edge[1]
            uf.union(x,y)
        }
        var res = 0
        for i in 0..<n {
            res += n - uf.getSize(uf.find(i))
        }
        return res / 2
    }
}

class UnionFind {
    var parents: [Int]
    var sizes: [Int]
    
    init(_ n: Int) {
        parents = Array(0..<n)
        sizes = Array(repeating: 1, count: n)
    }
    
    func find(_ x: Int) -> Int {
        if parents[x] == x {
            return x
        } else {
            parents[x] = find(parents[x])
            return parents[x]
        }
    }
    
    func union(_ x: Int, _ y: Int) {
        let rx = find(x), ry = find(y)
        if rx != ry {
            if sizes[rx] > sizes[ry] {
                parents[ry] = rx
                sizes[rx] += sizes[ry]
            } else {
                parents[rx] = ry
                sizes[ry] += sizes[rx]
            }
        }
    }
    
    func getSize(_ x: Int) -> Int {
        return sizes[x]
    }
}