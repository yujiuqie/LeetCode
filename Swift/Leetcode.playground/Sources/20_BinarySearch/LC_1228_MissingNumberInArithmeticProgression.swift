import Foundation

public class Solution_1228 {
    public func missingNumber(_ arr: [Int]) -> Int {
        let len = arr.count
        let dif = (arr.last! - arr.first!) / len
        var left = 0
        var right = len - 1
        
        //目的是找出缺失值左右的两个索引，终止条件是正好找到 left == right - 1 那个值
        while(left != right - 1){
            let mid = (left + right) >> 1
            
            //每次获得 mid 之后，结果必然是下面两种情况中的一个，直到 left == right - 1 停止
            
            //情况一：arr[mid] - arr[left] == dif * (mid - left) 说明从 left 到 mid 的数组元素等差值之和等于等差值与间距之积，说明左侧不缺失任何元素，left = mid
            if(arr[mid] - arr[left] == dif * (mid - left)){
                left = mid
            }
            //情况二：arr[right] - arr[mid] == dif * (right - mid) 说明从 mid 到 right 的数组元素等差值之和等于等差值与间距之积，说明右侧不缺失任何元素，right = mid
            else if(arr[right] - arr[mid] == dif * (right - mid)){
                right = mid
            }
        }
        
        return (arr[left] + arr[right]) / 2
    }
}

public class LC_1228_MissingNumberInArithmeticProgression : Solution_1228{
    public override init() {}
}
