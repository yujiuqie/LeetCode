class Solution {
    func canVisitAllRooms(_ rooms: [[Int]]) -> Bool {
        let size = rooms.count
        var visited = Array(repeating: false, count: size)
        dfs(0, rooms, &visited)
        for flag in visited {
            if !flag {
                return false
            }
        }
        return true
    }
    
    private func dfs(_ key: Int, _ rooms: [[Int]], _ visited: inout [Bool]) {
        if visited[key] {
            return
        }
        visited[key] = true
        for k in rooms[key] {
            dfs(k, rooms, &visited)
        }
    }
}