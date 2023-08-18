public class Solution_43 {
    public func multiply(_ num1: String, _ num2: String) -> String {
         if num1 == "0" || num2 == "0"{
            return "0"
        }
        
        let num_1 = Array(num1).map{ Int(String($0))! }
        let num_2 = Array(num2).map{ Int(String($0))! }

        let m = num_1.count
        let n = num_2.count

        var tmp = [Int](repeating: 0, count: m + n)

        //逆序末位填充
        for index_i in 1...m {
            let i = m - index_i
            let v_1 = num_1[i]
            for index_j in 1...n {
                let j = n - index_j
                let v_2 = num_2[j]
                let sum = tmp[i + j + 1] + v_1 * v_2
                tmp[i + j + 1] = sum % 10
                tmp[i + j] += sum / 10
            }
        }
        
        var index = 0
        while(tmp[index] == 0){
            index += 1
        }
        
        var string = ""
        for i in index..<m + n{
            string.append(String(tmp[i]))
        }
        
        return string
    }
}


public class LC_43_MultiplyStrings : Solution_43{
    public override init() {}
}
