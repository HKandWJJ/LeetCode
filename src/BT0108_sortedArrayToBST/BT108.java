package BT0108_sortedArrayToBST;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵二叉搜索树
 * *************************************************************************
 * 思路总结:
 * 选择中间位置左边的数字作为根节点，则根节点的下标为 mid=(left+right)/2
 * 依次递归
 * *************************************************************************
 * 时间复杂度: O(n)
 * 空间复杂度: O(logn)
 */
public class BT108 {
    public TreeNode sortArrayToBST(int[] nums){
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
