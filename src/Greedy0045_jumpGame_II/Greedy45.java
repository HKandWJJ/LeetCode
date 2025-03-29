package Greedy0045_jumpGame_II;

/**
 * 跳跃游戏 II：给定一个非负整数数组，最初位于数组的第一个位置。数组中的每个元素代表该位置可以跳跃的最大长度，目标是使用最少的跳跃次数到达数组的最后一个位置。
 * ****************************************************************************
 * 思路总结：
 * 1. 贪心算法：每次选择能跳到的最远的位置
 * 2. 维护一个变量end，表示当前能跳到的最远位置
 * 3. 维护一个变量maxPosition，表示从当前位置开始能跳到的最远位置
 * 4. 当遍历到end时，更新end为maxPosition，步数加1
 * 5. 最后返回步数
 * 注意：最后一个位置不需要跳跃，所以遍历到倒数第二个位置即可
 * ****************************************************************************
 * 时间复杂度：O(n), 其中n为数组的长度，最多遍历数组一次
 * 空间复杂度：O(1)
 */
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < length - 1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
