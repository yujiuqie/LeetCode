class Solution {
    func punishmentNumber(_ n: Int) -> Int {
        var ans = 0
        for i in 1...n {
            if dfs(i * i, i) {
                ans += i * i
            }
        }
        return ans
    }
    
    func dfs(_ t: Int, _ x: Int) -> Bool {
        if t == x {
            return true
        }
        var d = 10
        while t >= d && t % d <= x {
            if dfs(t / d, x - (t % d)) {
                return true
            }
            d *= 10
        }
        return false
    }
}