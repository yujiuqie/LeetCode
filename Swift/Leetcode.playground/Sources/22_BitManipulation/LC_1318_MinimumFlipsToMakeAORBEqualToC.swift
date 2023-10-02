class Solution {
    func minFlips(_ a: Int, _ b: Int, _ c: Int) -> Int {
        /*
        逐位分析+分类讨论
        由按位或的性质可以:
        0 | 0 = 0
        0 | 1 = 1
        1 | 1 = 1
        1.当c该位为0时，必须将a与b的该位均翻转为0，翻转次数为1的个数
        2.当c该位为1时，当且仅当a与b该位均为0时需要翻转1次，其余情况均不需要翻转
         */
        var res = 0
        for i in 0..<30 {
            let x = (a >> i) & 1, y = (b >> i) & 1, z = (c >> i) & 1
            if z == 0 {
                res += x + y
            } else {
                res += (x | y) ^ 1
            }
        }
        return res
    }
}