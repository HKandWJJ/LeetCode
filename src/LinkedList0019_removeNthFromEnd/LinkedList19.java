package LinkedList0019_removeNthFromEnd;

/**
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * *******************************
 * 解题思路：
 * 1. 定义一个快指针，一个慢指针，快指针先走 n 步，然后慢指针开始走。
 * 2. 当快指针走到了链表的末尾，那么慢指针指向的就是要删除的节点。
 * *********************************
 * 时间复杂度：O(L),其中 L 是链表的长度。
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
