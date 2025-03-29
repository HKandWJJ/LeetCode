package Greedy0055_jumpGame;

/**
 * 跳跃游戏：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
 * ************************************************************************************************
 * 思路总结：
 * 1、遍历数组，记录当前能够到达的最远位置rightmost。
 * 2、如果当前位置i小于等于rightmost，说明可以到达当前位置，更新rightmost为rightmost与i + nums[i]之间的最大值。
 * 3、如果rightmost大于等于数组长度n - 1，说明可以到达最后一个下标，返回true。
 * 4、如果遍历结束后没有返回true，说明无法到达最后一个下标，返回false。
 * ************************************************************************************************
 * 时间复杂度：O(n)，其中n是数组的长度。
 * 空间复杂度：O(1)。
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for(int i = 0; i < n; ++i){
            if(i <= rightmost){
                rightmost = Math.max(rightmost, i + nums[i]);
                if(rightmost >= n - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
