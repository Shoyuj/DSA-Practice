class Solution {
    public int[] productExceptSelf(int[] nums) {
        int c=0,pro=1,k=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            c++;
        }

        if(c>1)
        return arr;

        else if(c==1)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=0)
                {
                arr[i]=0;
                pro*=nums[i];
                }
                else
                k=i;
            }
            arr[k]=pro;

            return arr;
        }

        else
        {
            pro=1;
            arr[0]=1;
            for(int i=1;i<nums.length;i++)
            {
                pro*=nums[i-1];
                arr[i]=pro;
            }
            pro=1;
            for(int i=nums.length-2;i>=0;i--)
            {
                pro*=nums[i+1];
                arr[i]=pro*arr[i];
            }
            return arr;
        }
    }
}