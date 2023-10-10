class Solution {
    func reverseBits(_ n: Int) -> Int {
        var m = n
        var rev = 0
        for i in 0..<32 where m != 0 {

            //原串的第 i 位
            let bit = m & 1

            // 左移运算符 <<，可以将一个对象的二进制向左移 n 位，左边 n 位丢弃，右边 n 位补 0。比如，a = 1101 ，a << 2 = 0100
            // 将原串的第 i 位放到 res 的第 31 - i 位
            rev |= bit << (31 - i)

            //右移运算符 >>，可以将一个对象的二进制向右移 n 位，右边 n 位丢弃，左边 n 位补 0。比如，a = 1101 ，a >> 2 = 0011
            m >>= 1
        }
        return rev
    }
}