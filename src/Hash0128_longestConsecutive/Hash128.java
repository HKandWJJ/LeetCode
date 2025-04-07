package Hash0128_longestConsecutive;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums){
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num : nums){
            numSet.add(num);
        }
        int longest = 0;
        for(int num : numSet){
            if(!numSet.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
