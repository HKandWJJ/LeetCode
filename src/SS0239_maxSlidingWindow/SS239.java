package SS0239_maxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * *********************************************************************************************************************
 * 思路总结:
 * 1. 维护一个单调队列，队列中的元素是数组中的下标，队列中的元素从队头到队尾是单调递减的，即队列中的元素对应的数组值是单调递减的。
 * 2. 遍历数组，对于每个元素，将其与队列中的元素比较，如果当前元素大于队列中的元素，则将队列中的元素弹出，直到队列中的元素小于等于当前元素。
 * 3. 将当前元素的下标加入队列中。
 * 4. 如果当前元素的下标大于等于 k，则将队列中的第一个元素弹出，因为这个元素已经不在滑动窗口中了。
 * 5. 如果当前元素的下标大于等于 k - 1，则将队列中的第一个元素加入结果数组中，因为这个元素是滑动窗口中的最大值。
 * 6. 返回结果数组。
 * *********************************************************************************************************************
 * 时间复杂度: O(n),其中 n 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次
 * 空间复杂度: O(k),不断从队首弹出元素,保证了队列中最多不会有超过 k+1 个元素
 */
class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for(int i = k; i < n; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
