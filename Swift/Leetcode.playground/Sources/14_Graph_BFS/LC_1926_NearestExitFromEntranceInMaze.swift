class Solution {
    func nearestExit(_ maze: [[Character]], _ entrance: [Int]) -> Int {
        let start_x = entrance[0]
        let start_y = entrance[1]
        let dx = [1,-1,0,0]
        let dy = [0,0,1,-1]
        let m = maze.count
        let n = maze[0].count
        var queue = [[Int]]()
        queue.append([start_x,start_y,0])
        var maze = maze
        maze[start_x][start_y] = "+"
        while !queue.isEmpty {
            let point = queue.removeFirst()
            if !(point[0] == start_x && point[1] == start_y) && (point[0] == 0 || point[0] == m - 1 || point[1] == 0 || point[1] == n - 1) {
                return point[2]
            }
            for k in 0..<dx.count {
                let x = point[0] + dx[k]
                let y = point[1] + dy[k]
                if x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == "." {
                    queue.append([x,y,point[2] + 1])
                    maze[x][y] = "+"
                }
            }
        }
        return -1
    }
}