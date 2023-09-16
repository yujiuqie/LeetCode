class StockSpanner {

    Deque<int[]> dq = new ArrayDeque<>();
    int cur = 0;

    public StockSpanner() {

    }

    public int next(int price) {

        // 如果栈不空 且 栈顶元素小于 price，移除栈顶元素
        while (!dq.isEmpty() && dq.peekLast()[1] <= price) {
            dq.pollLast();
        }

        // 如果栈顶为空则 pre 取 -1 作为索引
        // 如果栈顶非空（大于 price），pre 取栈顶元素（大于 price）的索引
        int pre = dq.isEmpty() ? -1 : dq.peekLast()[0];

        // 当前索引减去栈顶索引，即为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）
        int res = cur - pre;

        // 将当前索引和价格存放入栈中用于下次计算
        dq.addLast(new int[] { cur++, price });

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

public class LC_901_OnlineStockSpan {

}
