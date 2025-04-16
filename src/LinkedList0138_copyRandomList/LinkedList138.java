package LinkedList0138_copyRandomList;

/**
 * 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * *********************************************
 * 思路总结：
 * 我们首先将该链表中每一个节点拆分为两个相连的节点，例如对于链表 A→B→C，我们可以将其拆分为 A→A′→B→B′→C→C′。
 * 对于任意一个原节点 S，其拷贝节点 S′即为其后继节点。
 * 这样，我们可以直接找到每一个拷贝节点 S′的随机指针应当指向的节点，即为其原节点 S 的随机指针指向的节点 T 的后继节点 T′。
 * 当我们完成了拷贝节点的随机指针的赋值，我们只需要将这个链表按照原节点与拷贝节点的种类进行拆分即可，只需要遍历一次。
 * *********************************************
 * 时间复杂度：O(n)，其中 n 是链表的长度。我们只需要遍历该链表三次。
 * 空间复杂度：O(1)。注意返回值不计入空间复杂度。
 */
class Solution{
    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        for(Node node = head; node != null; node = node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for(Node node = head; node != null; node = node.next.next){
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for(Node node = head; node != null; node = node.next){
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
