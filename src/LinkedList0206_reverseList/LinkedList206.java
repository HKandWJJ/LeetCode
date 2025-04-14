package LinkedList0206_reverseList;

/**
 * 反转链表:
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * ************************************************
 * 思路总结:
 * 1. 定义一个prev指针，初始化为null
 * 2. 定义一个curr指针，初始化为head
 * 3. 定义一个next指针，初始化为curr.next
 * 4. 循环遍历链表，直到curr为null
 * 5. 在循环中，将curr.next指向prev
 * 6. 将prev指向curr
 * 7. 将curr指向next
 * 8. 返回prev
 * ************************************************
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution{
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
