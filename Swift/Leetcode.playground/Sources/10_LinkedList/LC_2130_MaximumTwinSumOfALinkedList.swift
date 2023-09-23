/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func pairSum(_ head: ListNode?) -> Int {

        var slow = head
        var fast = head
        
        while fast?.next != nil && fast?.next?.next != nil {
            slow = slow?.next
            fast = fast?.next?.next
        }

        let next = reverse(slow)
        var max = Int.min
        var currentHead = head
        var currentNext = next
        while currentHead != nil && currentNext != nil {
            guard let val1 = currentHead?.val, let val2 = currentNext?.val else{
                return 0
            }

            max = Swift.max(max, val1 + val2)
            currentHead = currentHead?.next
            currentNext = currentNext?.next
        }
        return max
    }

    func reverse(_ head: ListNode?) -> ListNode? {
        if head == nil || head?.next == nil {
            return head
        }
        var pre: ListNode? = nil
        var cur: ListNode? = head
        while cur != nil {
            var temp: ListNode? = cur?.next
            cur?.next = pre
            pre = cur
            cur = temp
        }
        return pre
    }
}