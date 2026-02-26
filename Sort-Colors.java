1class Solution {
2    public void sortColors(int[] nums) {
3        
4      int i=0,k=0,c0=0,c1=0,c2=0;
5
6      for(i=0;i<nums.length;i++)
7      {
8        if(nums[i]==0)
9        c0++;
10        else if(nums[i]==1)
11        c1++;
12        else
13        c2++;
14      }
15
16      for(i=0;i<nums.length;i++)
17      {
18        if(i<c0)
19        nums[k++]=0;
20
21        else if(i>=c0 && i<c0+c1)
22        nums[k++]=1;
23
24        else
25        nums[k++]=2;
26      }
27    }
28}