package Heap0295_findMedian;

import java.util.PriorityQueue;

/**
 * 数据流的中位数：动态添加数字，并随时可以获取已添加数字的中位数
 * ****************************************************************************
 *思路总结：
 * 1、准备两个优先队列，一个是queMin大顶堆，一个是queMax小顶堆。queMin存储较小的一半数字，queMax存储较大的一半数字。
 * 2、如果queMin为空或新添加的数字小于等于queMin的堆顶元素，就将其添加到queMin中；
 *  之后检查，如果 queMin 里的数字比 queMax 里的数字多超过 1 个，就把 queMin 堆顶的数字移到 queMax 中。
 *  要是新数字大于 queMin 的堆顶元素，就把它加入 queMax。
 *  接着检查，如果 queMax 里的数字比 queMin 多，就把 queMax 堆顶的数字移到 queMin 中。
 * 3、如果两个堆的大小相等，说明总元素数量为偶数，中位数就是两个堆的堆顶元素的平均值；否则，中位数就是queMin的堆顶元素。
 * ****************************************************************************
 * 补充：
 * PriorityQueue：优先级队列，会根据元素的优先级对元素进行排序，确保队首元素始终是优先级最高的元素。不允许存储null元素，线程不安全，动态扩容。
 * PriorityQueue<Integer> queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
 * 比较器Comparator:(a, b) -> (b - a)是一个Lambda表达式，表示当比较两个元素a和b时，返回b - a的结果。
 * ****************************************************************************
 * 时间复杂度：addNum :O(logn)，其中n是已添加的数字的数量。
 *          findMedian :O(1)，直接返回两个优先队列的堆顶元素。
 * 空间复杂度：O(n)，其中n是已添加的数字的数量，用于存储优先队列。
 */
class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if(queMin.isEmpty() || num <= queMin.peek()){
            queMin.offer(num);
            if(queMax.size() + 1 < queMin.size()){
                queMax.offer(queMin.poll());
            }
        }else{
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
