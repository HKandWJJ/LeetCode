package BT0101_isSymmetric;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * *************************************
 * 思路总结:
 * 1.递归判断左右子树是否对称, 即左子树的左子树是否等于右子树的右子树，左子树的右子树是否等于右子树的左子树。
 */
public class BT101 {
    public boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q){
        if(p == null & q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
