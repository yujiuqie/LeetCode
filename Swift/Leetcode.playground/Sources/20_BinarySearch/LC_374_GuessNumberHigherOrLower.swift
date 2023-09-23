class Solution : GuessGame {
    func guessNumber(_ n: Int) -> Int {
        var left = 1
        var right = n
        while left < right {
            let mid = left + (right - left) / 2
            if guess(mid) <= 0 {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}