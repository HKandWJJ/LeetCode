package BT0226_invertTree;

/**
 * 翻转二叉树
 * 给定一个二叉树，翻转它的左右子树。
 * *************************************
 * 思路总结:
 * 1.递归翻转左右子树, 然后交换左右子树的位置,即根节点的左节点指向右子树，右节点指向左子树。
 */
public class BT226 {
    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
