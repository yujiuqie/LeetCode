import Foundation

public class Solution_833 {
    public func findReplaceString(_ s: String, _ indices: [Int], _ sources: [String], _ targets: [String]) -> String {
        let m = s.count
        let n = indices.count
        
        var map : [Int:Int] = [:]
        for i in 0..<n {
            map[indices[i]] = i
        }
        
        var ans = ""
        
        var index = 0
        while(index < m) {
            var succeed = false
            if let pt = map[index]{
                
                let startIndex = s.index(s.startIndex,offsetBy: index)
                let endIndex = s.index(s.startIndex,offsetBy: index + sources[pt].count)
                let subString = s[startIndex..<endIndex]
                
                if(subString == sources[pt]){
                    succeed = true;
                    ans += targets[pt];
                    index += sources[pt].count
                }
            }
            
            if(!succeed){
                
                let startIndex = s.index(s.startIndex,offsetBy: index)
                let endIndex = s.index(s.startIndex,offsetBy: index + 1)
                let subString = s[startIndex..<endIndex]
                
                ans += subString
                index += 1
            }
        }
        
        return ans;
    }
}

public class LC_833_FindAndReplaceInString : Solution_833{
    public override init() {}
}
