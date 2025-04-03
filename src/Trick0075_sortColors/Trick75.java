package Trick0075_sortColors;

/**
 * 颜色分类:给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * *******************************************************************************************
 * 思路总结:
 * 1. 单指针: 遍历数组, 将0放到数组的最前面, 1放到0的后面，剩下的为2
 * *******************************************************************************************
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution_singlePointer {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}

/**
 * 双指针: 遍历数组, 将0放到数组的最前面, 2放到数组的最后面, 剩下的为1
 * ************************************************************
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution_doublePointer {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for(int i = 0; i <= p2; i++){
            while(i <= p2 && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}