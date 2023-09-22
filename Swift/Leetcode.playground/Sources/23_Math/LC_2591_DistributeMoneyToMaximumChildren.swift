class Solution {
    func distMoney(_ money: Int, _ children: Int) -> Int {
      if money < children {
            return -1
        }
        if 8 * (children - 1) + 4 == money {
            return children - 2
        }
        if money > children * 8 {
            return children - 1
        }
        return (money - children) / 7
    }
}