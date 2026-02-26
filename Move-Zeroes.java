1class Solution {
2    public void moveZeroes(int[] nums) {
3        int i=0,k=0;
4        for(i=0;i<nums.length;i++)
5        {
6            if(nums[i]!=0)
7            nums[k++]=nums[i];
8        }
9        for(;k<nums.length;k++)
10        {
11            nums[k]=0;
12        }
13    }
14}