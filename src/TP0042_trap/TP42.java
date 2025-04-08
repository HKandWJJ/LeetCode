package TP0042_trap;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * ************************************************************************
 * 思路总结:
 * 双指针：
 * 1. 定义两个指针left和right，分别指向数组的左右两端。
 * 2. 定义两个变量leftMax和rightMax，分别表示左右指针所指位置的左边和右边的最大高度。
 * 3. 当left小于right时，执行以下操作：
 *      a. 如果height[left]小于height[right]，则更新leftMax为Math.max(leftMax, height[left])，
 *          并计算当前位置的雨水量为leftMax - height[left]，累加到ans中，然后将left右移一位。
 *      b. 否则，更新rightMax为Math.max(rightMax, height[right])，
 *          并计算当前位置的雨水量为rightMax - height[right]，累加到ans中，然后将right左移一位。
 * 4. 当left大于等于right时，循环结束，返回ans作为结果。
 * ***************************************************************************
 * 时间复杂度：O(n)，其中n是数组的长度。
 * 空间复杂度：O(1)。
 */
class Solution{
    public int trap(int[] height){
        int ans =0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                ++left;
            }else {
                ans += rightMax- height[right];
                --right;
            }
        }
        return ans;
    }
}