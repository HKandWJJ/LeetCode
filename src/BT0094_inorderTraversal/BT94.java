package BT0094_inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历:
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * *******************************************
 * 思路总结：递归
 * 定义 inorder(root) 表示当前遍历到 root 节点的答案，递归调用 inorder(root.left) 来遍历 root 节点的左子树，
 * 然后将 root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 root 节点的右子树即可
 * 递归终止的条件为碰到空节点。
 */
public class BT94 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
