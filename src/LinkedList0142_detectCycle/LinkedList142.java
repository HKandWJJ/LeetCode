package LinkedList0142_detectCycle;

/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * *******************************
 * 解题思路：
 * 1. 定义一个快指针，一个慢指针，快指针每次走两步，慢指针每次走一步，如果存在环，那么快指针一定会追上慢指针。
 * 2. 如果快指针走到了链表的末尾，那么说明链表中没有环。
 * 3. 如果快指针追上了慢指针，那么说明链表中存在环。
 * 4. 定义一个指针，指向链表的头节点，然后让慢指针和这个指针一起走，当慢指针和这个指针相遇时，那么这个指针就是链表开始入环的第一个节点。
 * 数学推理：
 * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。
 * 此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
 * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。
 * 因此，我们有 a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
 * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
 * *********************************
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            } else{
                return null;
            }
            if(fast == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
