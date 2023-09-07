class Solution_1431 {
    func kidsWithCandies(_ candies: [Int], _ extraCandies: Int) -> [Bool] {
        guard let max = candies.max() else { return [] }
        return candies.map { return $0 + extraCandies >= max }
    }
}

public class LC_1431_KidsWithTheGreatestNumberOfCandies : Solution_1431 {
    public override init() {}
}
