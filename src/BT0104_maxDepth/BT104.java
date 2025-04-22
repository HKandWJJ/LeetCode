package BT0104_maxDepth;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * *************************************
 * 思路总结:
 * 1.深度优先搜索：分别递归遍历左右子树，返回左右子树的最大深度加1
 */
public class BT104 {
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        } else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
