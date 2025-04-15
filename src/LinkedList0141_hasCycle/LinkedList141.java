package LinkedList0141_hasCycle;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * *******************************
 * 解题思路：
 * 1. 定义一个快指针，一个慢指针，快指针每次走两步，慢指针每次走一步，如果存在环，那么快指针一定会追上慢指针。
 * 2. 如果快指针走到了链表的末尾，那么说明链表中没有环。
 * 3. 如果快指针追上了慢指针，那么说明链表中存在环。
 * *********************************
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution{
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
