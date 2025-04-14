package Matrix0240_searchMatrix;

/**
 * 搜索二维矩阵 II:编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * *************************************************************************
 * 思路总结：
 * 1. 从右上角开始搜索
 * 2. 如果当前元素等于目标值，返回 true
 * 3. 如果当前元素大于目标值，说明当前元素所在的列可以被排除
 * 4. 如果当前元素小于目标值，说明当前元素所在的行可以被排除
 * 5. 如果搜索完整个矩阵，仍然没有找到目标值，返回 false
 * *****************************************************************************
 * 时间复杂度: O(m + n)
 * 空间复杂度: O(1)
 */
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while(x < m && y >= 0){
            if(matrix[x][y] == 0){
                return true;
            } else if(matrix[x][y] > target){
                y--;
            } else{
                x++;
            }
        }
        return false;
    }
}
