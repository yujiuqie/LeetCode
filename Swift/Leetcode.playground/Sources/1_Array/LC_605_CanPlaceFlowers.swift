class Solution {
    func canPlaceFlowers(_ flowerbed: [Int], _ n: Int) -> Bool {
        let len = flowerbed.count
        var count = n
        var flow = Array(repeating: 0, count: len + 2)
        for i in 0..<len + 1 {
            if i == 0 || i == len + 1 {
                flow[i] = 0
            } else {
                flow[i] = flowerbed[i - 1]
            }
        }
        for i in 1..<len + 1 {
            if flow[i - 1] == 0 && flow[i] == 0 && flow[i + 1] == 0 {
                flow[i] = 1
                count -= 1
            }
        }
        return count <= 0
    }
}