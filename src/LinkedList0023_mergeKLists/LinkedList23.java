package LinkedList0023_mergeKLists;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * *******************************************************
 * 思路总结：
 * 维护当前每个链表没有被合并的元素的最前面一个，k 个链表就最多有 k 个满足这样条件的元素，每次在这些元素里面选取 val 属性最小的元素合并到答案中。
 * 在选取最小元素的时候，我们可以用优先队列来优化这个过程。
 * *********************************************************
 * 时间复杂度：O(kn×logk),考虑优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk),这里最多有 kn 个点，对于每个点都被插入删除各一次
 *          故总的时间代价即渐进时间复杂度为 O(kn×logk)。
 * 空间复杂度：O(k),这里用了优先队列，优先队列中的元素不超过 k 个。
 */
class Solution{
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;
        Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }
        public int compareTo(Status status2){
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status >();

    public ListNode mergeKLists(ListNode[] lists){
        for(ListNode node : lists){
            if(node != null){
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if(f.ptr.next != null){
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
