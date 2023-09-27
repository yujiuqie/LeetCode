class Solution {
    func filterRestaurants(_ restaurants: [[Int]], _ veganFriendly: Int, _ maxPrice: Int, _ maxDistance: Int) -> [Int] {
        var sortedRestaurants = restaurants.sorted(by: { $0[1] == $1[1] ? $1[0] < $0[0] : $1[1] < $0[1] })
        var res = [Int]()
        for r in sortedRestaurants {
            if r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance {
                res.append(r[0])
            }
        }
        return res
    }
}