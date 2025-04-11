package Matrix0054_spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * ********************************************************
 * 思路总结:
 * 1. 首先，创建一个列表 order 用于存储矩阵中的元素。
 * 2. 然后，定义四个变量 left、right、top、bottom，分别表示当前遍历的左边界、右边界、上边界和下边界。
 * 3. 接着，使用 while 循环遍历矩阵，直到 left > right 或 top > bottom 为止。
 * 4. 在每次循环中，从左到右遍历当前行，将元素加入列表 order 中。
 * 5. 然后，从上到下遍历当前列，将元素加入列表 order 中。
 * 6. 如果 left < right 且 top < bottom，则从右到左遍历当前行，将元素加入列表 order 中。
 * 7. 最后，从下到上遍历当前列，将元素加入列表 order 中。
 * 8. 遍历完当前行和列后，更新 left、right、top、bottom 的值，继续遍历下一层。
 * 9. 最后，返回列表 order 即可。
 * ********************************************************
 * 时间复杂度：O(mn)，其中 m 和 n 分别是矩阵的行数和列数。
 * 空间复杂度：O(1)。
 */
class Solution{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> order = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom){
            for(int column = left; column <= right; column++){
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++){
                order.add(matrix[row][right]);
            }
            if(left < right && top < bottom){
                for(int column = right - 1; column >= left; column--){
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom - 1; row > top; row--){
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
