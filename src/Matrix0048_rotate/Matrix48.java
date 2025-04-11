package Matrix0048_rotate;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * ********************************************************
 * 思路总结:
 * 1. 首先，定义一个变量 n 表示矩阵的大小。
 * 2. 然后，使用一个两层循环遍历矩阵的左上角四分之一部分，对于每个元素 matrix[i][j]，将其旋转到相应的位置。
 * 3. 旋转的过程中，需要使用一个临时变量 temp 来保存旋转后的元素。
 * 4. 最后，返回旋转后的矩阵即可。
 * ********************************************************
 * 时间复杂度：O(n^2)，其中 n 是矩阵的大小。
 * 空间复杂度：O(1)。
 */
class Solution{
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < (n + 1) / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j -1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
