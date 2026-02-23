1class Solution {
2    public int removeDuplicates(int[] nums) {
3        
4        int rd =0;
5        for(int i=1;i<nums.length;i++){
6            if(nums[rd]!=nums[i]){
7                rd++;
8                nums[rd]=nums[i];
9            }
10        }
11        return rd + 1;
12    }
13}