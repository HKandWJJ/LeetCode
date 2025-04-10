package Array0056_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * ***********************************************************************
 * 思路总结:
 * 首先，将所有区间按照起始端点进行排序。
 * 然后，遍历排序后的区间列表，对于每个区间，检查它是否与前一个区间重叠。
 * 如果重叠，更新前一个区间的结束端点为当前区间的结束端点。
 * 如果不重叠，将当前区间添加到结果列表中。
 * 最后，将结果列表转换为数组并返回。
 * ***********************************************************************
 * 时间复杂度: O(nlogn)，其中 n 是区间的数量。
 * 空间复杂度: O(logn)，用于排序的栈空间。
 * **********************************************************************
 * 补充:
 * Comparator.comparingInt(interval -> interval[0]) 是一个比较器，用于指定排序规则
 */
class Solution{
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int n = intervals.length;
        int i = 0;
        List<int[]> ranges = new ArrayList<int[]>();
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while(j < n && intervals[j][0] <= end){
                end = Math.max(intervals[j++][1], end);
            }
            ranges.add(new int[]{start, end});
            i = j;
        }
        return ranges.toArray(new int[ranges.size()][]);
    }
}
