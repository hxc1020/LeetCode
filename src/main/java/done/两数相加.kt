//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class 两数相加 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        val result = ListNode(0)
        var l1c: ListNode? = l1
        var l2c: ListNode? = l2
        var c: ListNode? = result

        while (l1c != null || l2c != null) {
            var value = (l1c?.`val` ?: 0) + (l2c?.`val` ?: 0) + carry
            if (value > 9) {
                value %= 10
                carry = 1
            } else {
                carry = 0
            }
            c?.next = ListNode(value)
            c = c?.next
            if (l1?.next != null) l1c = l1c?.next
            if (l2?.next != null) l2c = l2c?.next
        }
        if (carry == 1) {
            c?.next = ListNode(1)
        }
        return result.next
    }
}