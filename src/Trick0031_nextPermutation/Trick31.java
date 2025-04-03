package Trick0031_nextPermutation;

/**
 * 下一个排列:整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * **************************************************************************
 * 思路总结:
 * 1. 找到第一个降序位置 i：
 *      从数组的倒数第二个元素开始向前遍历，找到第一个满足 nums[i] < nums[i + 1] 的位置 i。这意味着从位置 i + 1 到数组末尾的元素是降序排列的。
 * 2. 找到第一个大于 nums[i] 的元素 nums[j]：
 *      如果找到了位置 i，则从数组的最后一个元素开始向前遍历，找到第一个满足 nums[i] < nums[j] 的位置 j。
 * 3. 交换 nums[i] 和 nums[j]：
 *      交换 nums[i] 和 nums[j] 的值，这样可以保证新的排列比原排列大。
 * 4. 反转从 i + 1 到数组末尾的元素：
 *      反转从位置 i + 1 到数组末尾的所有元素，因为这些元素在交换后仍然是降序排列的，反转后可以得到最小的排列。
 * **************************************************************************
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
