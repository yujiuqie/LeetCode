public class StringIterator {

    var index = 0
    var group_ch : [String] = []
    var group_num : [Int] = []

    public init(_ compressedString: String) {
        let regex = /\D|\d+/
        let res = compressedString.matches(of: regex)
        
        for i in 0...res.count - 1{
            if(i % 2 == 0){
                group_ch.append(String(res[i].output))
            }
            else{
                group_num.append(Int(res[i].output) ?? 0)
            }
        }
    }
    
    public func next() -> Character {
        if(!hasNext()){
            return " "
        }

        let res = group_ch[index]
        group_num[index] -= 1

        if(group_num[index] == 0){
            index += 1
        }

        return res[res.startIndex]
    }
    
    public func hasNext() -> Bool {
        return group_num[index] > 0
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * let obj = StringIterator(compressedString)
 * let ret_1: Character = obj.next()
 * let ret_2: Bool = obj.hasNext()
 */
