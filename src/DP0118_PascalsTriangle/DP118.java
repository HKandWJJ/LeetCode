package DP0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角:在杨辉三角中，每个数是它左上方和右上方的数的和。
 * ******************************************************
 * 思路总结：
 * 1. 杨辉三角的行数为numRows
 * 2. 杨辉三角的第i行有i+1个元素
 * 3. 杨辉三角的第i行的第j个元素为第i-1行的第j-1个元素和第j个元素的和
 * ******************************************************
 * 时间复杂度：O(numRows^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; ++i){
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j==i){
                    row.add(1);
                }else{
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}