package Heap0347_topKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
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
