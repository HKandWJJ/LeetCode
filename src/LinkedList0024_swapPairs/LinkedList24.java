package LinkedList0024_swapPairs;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * *******************************
 * 解题思路：
 * 1. 定义一个新的链表，然后定义一个指针，指向新链表的头节点。
 * 2. 定义两个指针，分别指向两个链表的头节点。
 * 3. 比较两个指针指向的节点的值，将较小的值加入到新链表中。
 * 4. 当一个链表的指针走到了末尾，那么将另一个链表的指针加入到新链表中。
 * 5. 返回新链表的头节点。
 * *********************************
 * 时间复杂度：O(n),其中 n 是链表的长度。
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode swapPairs(ListNode head){
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
