package Array0189_rotate;

/**
 * 旋转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * ***********************************************************************
 * 思路总结:
 * 首先，将整个数组进行翻转，这样数组的顺序就被反转了。
 * 然后，将数组的前 k 个元素进行翻转，这样前 k 个元素的顺序就被反转了。
 * 最后，将数组的剩余元素进行翻转，这样剩余元素的顺序就被反转了。
 * ***********************************************************************
 * 时间复杂度: O(n)，其中 n 是数组的长度。
 * 空间复杂度: O(1)，只使用了常数级别的额外空间。
 */
class Solution{
    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
