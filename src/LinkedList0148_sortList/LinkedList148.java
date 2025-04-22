package LinkedList0148_sortList;

/**
 * 排序链表
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * *******************************************************
 * 思路总结：
 * 自底向上归并排序
 * 1. 用 subLength 表示每次需要排序的子链表的长度，初始时 subLength=1。
 * 2. 每次将链表拆分成若干个长度为 subLength 的子链表（最后一个子链表的长度可以小于 subLength），按照每两个子链表一组进行合并，
 *    合并后即可得到若干个长度为 subLength×2 的有序子链表（最后一个子链表的长度可以小于 subLength×2）。
 *    合并两个子链表仍然使用「21. 合并两个有序链表」的做法。
 * 3. 将 subLength 的值加倍，重复第 2 步，对更长的有序子链表进行合并操作，直到有序子链表的长度大于或等于 length，整个链表排序完毕。
 * *******************************************************
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
class Solution{
    public ListNode sortList(ListNode head){
        if(head == null) return null;
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for(int subLength = 1; subLength < length; subLength <<= 1){
            ListNode prev = dummyHead, curr = dummyHead.next;
            while(curr != null){
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i = 1; i < subLength && curr != null && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1, head2);
                while(prev.next != null){
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
