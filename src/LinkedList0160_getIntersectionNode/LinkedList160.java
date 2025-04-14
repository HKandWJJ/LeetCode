package LinkedList0160_getIntersectionNode;

/**
 * 相交链表:给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * **********************************************************************************************************
 * 解题思路:
 * 1. 定义两个指针pA和pB，分别指向headA和headB
 * 2. 当pA和pB不相等时，pA和pB继续遍历，当pA遍历完headA时，pA指向headB，当pB遍历完headB时，pB指向headA
 * 3. 当pA和pB相等时，返回pA
 * 数学依据：链表 headA 和 headB 的长度分别是 m 和 n。假设链表 headA 的不相交部分有 a 个节点，链表 headB 的不相交部分有 b 个节点，
 * 两个链表相交的部分有 c 个节点，则有 a+c=m，b+c=n。
 * 如果 a=b，则两个指针会同时到达两个链表相交的节点并返回；
 * 如果 a!=b，则指针 pA 会遍历完链表 headA，指针 pB 会遍历完链表 headB，两个指针不会同时到达链表的尾节点，然后指针 pA 移到链表 headB 的头节点，
 * 指针 pB 移到链表 headA 的头节点，然后两个指针继续移动，在指针 pA 移动了 a+c+b 次、指针 pB 移动了 b+c+a 次之后，两个指针会同时到达两个链表相交的节点，
 * 该节点也是两个指针第一次同时指向的节点，返回该节点。
 * **********************************************************************************************************
 * 时间复杂度:O(m+n)
 * 空间复杂度:O(1)
 */
class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
