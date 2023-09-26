class Solution {
    func passThePillow(_ n: Int, _ time: Int) -> Int {
        let round = 2 * (n - 1)
        let step = time % round
        return (step < n ? step : round - step) + 1
    }
}