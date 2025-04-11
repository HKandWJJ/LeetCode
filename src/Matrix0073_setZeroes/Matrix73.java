package Matrix0073_setZeroes;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * ********************************************************
 * 思路总结:
 * 1. 首先，创建两个布尔数组 row 和 col，分别用于标记矩阵中哪些行和哪些列需要被置零。
 * 2. 然后，遍历矩阵，对于每个元素 matrix[i][j]，如果它为 0，则将 row[i] 和 col[j] 都设为 true，表示第 i 行和第 j 列需要被置零。
 * 3. 最后，再次遍历矩阵，对于每个元素 matrix[i][j]，如果 row[i] 或 col[j] 为 true，则将 matrix[i][j] 设为 0。
 * ********************************************************
 * 时间复杂度：O(mn)，其中 m 和 n 分别是矩阵的行数和列数。
 * 空间复杂度：O(m+n)。
 */
class Solution{
    public void setZeroes(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}