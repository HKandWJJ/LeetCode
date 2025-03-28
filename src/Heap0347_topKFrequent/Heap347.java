package Heap0347_topKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 前k个高频元素：给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * ****************************************************************************
 * 思路总结：
 * 1、遍历数组，用HashMap存储每个元素出现的次数，如果数字已在HashMap中，则将其对应的值加1；如果数字不在HashMap中，则将其添加到HashMap中，并将其对应的值设为1。
 * 2、准备一个容量为k的“小顶堆”(PriorityQueue)，并按元素出现次数从小到大排列；遍历HashMap：
 * 	如果堆的大小小于k（堆不满），将数字和次数一起添加到堆中；
 * 	如果堆的大小等于k（堆已满），将元素与堆顶元素（也就是出现次数最少的元素）进行比较：如果当前数字的次数更大，就把堆顶元素“踢出去”，把当前数字放进去
 * 3、遍历结束后，堆中剩下的k个元素就是前k个高频元素，把它们存到一个新数组里返回。
 * ****************************************************************************
 * 补充：
 * PriorityQueue：优先级队列，会根据元素的优先级对元素进行排序，确保队首元素始终是优先级最高的元素。不允许存储null元素，线程不安全，动态扩容。
 * PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator) ：创建一个指定初始容量的优先队列，元素按照指定的比较器排序。
 * 下述代码：
 * PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
 * 		public int compare(int[] m, int[] n) {
 * 			return m[1] - n[1];
 * 		}
 * });
 * 相当于：
 * class ArrayComparator implements Comparator<int[]> {
 * 		@Override
 * 		public int compare(int[] m, int[] n) {
 * 			return m[1] - n[1];
 * 		}
 * }
 * ArrayComparator arrayComparator = new ArrayComparator();
 * PriorityQueue<int[]> queue = new PriorityQueue<int[]>(arrayComparator);
 */


//前k个高频元素
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //使用entry方法获取 Map 中的所有键值对
        // peek获查看队首元素，poll获取并移除队首元素，offer插入元素到队尾
        // 与add插入相比，offer在插入失败时返回false，而add在插入失败时抛出异常。
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
