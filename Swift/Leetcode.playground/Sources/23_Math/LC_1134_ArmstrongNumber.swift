import Foundation

public class Solution_1134 {
    public func isArmstrong(_ n: Int) -> Bool {
        var num = n
        let s_num = String(num)
        let len = s_num.count
        var sum = 0
        
        while(num > 0){
            sum += Int(pow(Double(num % 10),Double(len)))
            num /= 10
        }
        
        return sum == n
    }
}


public class LC_1134_ArmstrongNumber : Solution_1134 {
    public override init() {}
}
