1class Solution {
2    public boolean check(int[] nums) {
3        int l=nums.length,i=0,j=0;
4        for(i=0;i<l-1;i++)
5        {
6            if(nums[i]>nums[i+1])
7            break;
8        }
9        for(j=i+1;j<l+i;j++)
10        {
11            if(nums[(j+1)%l]<nums[j%l])
12            return false;
13        }
14        return true;
15    }
16}