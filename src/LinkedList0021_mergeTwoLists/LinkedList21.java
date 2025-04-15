package LinkedList0021_mergeTwoLists;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * *******************************
 * 解题思路：
 * 1. 定义一个新的链表，然后定义一个指针，指向新链表的头节点。
 * 2. 定义两个指针，分别指向两个链表的头节点。
 * 3. 比较两个指针指向的节点的值，将较小的值加入到新链表中。
 * 4. 当一个链表的指针走到了末尾，那么将另一个链表的指针加入到新链表中。
 * 5. 返回新链表的头节点。
 * *********************************
 * 时间复杂度：O(m + n),其中 n 和 m 分别为两个链表的长度。
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
