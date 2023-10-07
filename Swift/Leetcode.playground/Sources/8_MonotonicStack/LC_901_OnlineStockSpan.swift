class StockSpanner {

    var dq = Array<(Int,Int)>()
    var cur = 0

    init() {

    }
    
    func next(_ price: Int) -> Int {
        //将栈顶小于 price 的元素都移除，保持整个栈单调递减
        while !dq.isEmpty && dq.last!.1 <= price{
            dq.removeLast()
        }

        let pre = dq.isEmpty ? -1 : dq.last!.0
        let res = cur - pre
        dq.append((cur,price))
        cur += 1

        return res
    }
}