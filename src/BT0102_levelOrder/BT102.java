package BT0102_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * ********************************************************************
 * 思路总结:
 * 广度优先遍历
 * 1. 首先根元素入队
 * 2. 当队列不为空的时候
 * 2.1 求当前队列的长度s
 * 2.2 依次从队列中取s个元素进行拓展，然后进入下一次迭代
 * ********************************************************************
 * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每个节点访问一次。
 * 空间复杂度：O(n)，其中 n 是二叉树的节点数。空间复杂度取决于队列存储的元素数量，
 * 队列中的元素个数不会超过 n。
 */
public class BT102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for(int i = 1; i <= currentLevelSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ret.add(level);
        }
        return ret;
    }
}
