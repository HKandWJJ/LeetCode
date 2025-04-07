package TP0283_moveZeroes;

/**
 * 移动零:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * ***********************************************************************
 * 思路总结:
 * 1. 双指针, 左指针指向下一个不为0的元素应该存放的位置，右指针遍历数组，寻找不为零的元素与左指针交换
 * *************************************************************************
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution{
    public void moveZeroes(int[] nums){
        int n = nums.length, l = 0, r = 0;
        while(r < n){
            if(nums[r] != 0){
                swap(nums, l , r);
                l++;
            }
            r++;
        }
    }
    public void swap(int[] sums, int l, int r){
        int temp = sums[l];
        sums[l] = sums[r];
        sums[r] = temp;
    }
}
