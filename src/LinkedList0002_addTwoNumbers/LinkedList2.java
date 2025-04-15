package LinkedList0002_addTwoNumbers;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * *******************************
 * 解题思路：
 * 1. 定义一个新的链表，然后定义一个指针，指向新链表的头节点。
 * 2. 定义两个指针，分别指向两个链表的头节点。
 * 3. 比较两个指针指向的节点的值，将较小的值加入到新链表中。
 * 4. 当一个链表的指针走到了末尾，那么将另一个链表的指针加入到新链表中。
 * 5. 返回新链表的头节点。
 * *********************************
 * 时间复杂度：O(max(m, n)),其中 n 和 m 分别为两个链表的长度。
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1 != null && l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            } else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
