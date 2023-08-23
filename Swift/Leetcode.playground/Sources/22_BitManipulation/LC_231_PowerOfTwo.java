class Solution_231_1 {
    public boolean isPowerOfTwo(int n) {
        //(n & (n - 1)) 直接将二进制表示的最低位 1 移除
        //一个数是 2 的幂，当且仅当这个数是正整数，且这个数的二进制表示中仅包含 1 个 1
        return n > 0 && (n & (n - 1)) == 0;
    }
}

class Solution_231_2 {
    public boolean isPowerOfTwo(int n) {
        //(n & -n) 直接可以获取二进制表示的最低位的 1
        //一个数是 2 的幂，当且仅当这个数是正整数，且这个数的二进制表示中仅包含 1 个 1
        return n > 0 && (n & -n) == n;
    }
}