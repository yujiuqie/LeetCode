class Solution {
    func orangesRotting(_ grid: [[Int]]) -> Int {
        let m = grid.count
        let n = grid[0].count
        var time = 0
        var fresh = 0
        var queue = [Int]()
        for i in 0..<m {
            for j in 0..<n {
                if grid[i][j] == 1 {
                    fresh += 1
                }
                if grid[i][j] == 2 {
                    queue.append(i * n + j)
                }
            }
        }

        var oranges = grid
        let directions = [[0,1],[0,-1],[1,0],[-1,0]]
        while !queue.isEmpty && fresh > 0 {
            let size = queue.count
            for _ in 0..<size {
                let cur = queue.removeFirst()
                let row = cur / n
                let col = cur % n
                for direction in directions {
                    let nRow = row + direction[0]
                    let nCol = col + direction[1]
                    if nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || oranges[nRow][nCol] != 1 {
                        continue
                    }
                    oranges[nRow][nCol] = 2
                    queue.append(nRow * n + nCol)
                    fresh -= 1
                }
            }
            time += 1
        }
        return fresh == 0 ? time : -1
    }
}