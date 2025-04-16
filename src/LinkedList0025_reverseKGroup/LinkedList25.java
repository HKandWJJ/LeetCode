package LinkedList0025_reverseKGroup;

/**
 * K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * *********************************************
 * 思路总结：
 * 把链表节点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头节点。这个指针每次向前移动 k 步，直至链表结尾。
 * 对于每个分组，我们先判断它的长度是否大于等于 k。若是，我们就翻转这部分链表，否则不需要翻转。
 * 但是对于一个子链表，除了翻转其本身之外，还需要将子链表的头部与上一个子链表连接，以及子链表的尾部与下一个子链表连接。
 * 因此，在翻转子链表的时候，我们不仅需要子链表头节点 head，还需要有 head 的上一个节点 pre，以便翻转完后把子链表再接回 pre。
 * *********************************************
 * 时间复杂度：O(n)，其中 n 为链表的长度。head 指针会在 O(n/k) 个节点上停留，每次停留需要进行一次 O(k) 的翻转操作。
 * 空间复杂度：O(1)，我们只需要建立常数个变量。
 */
class Solution{
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
