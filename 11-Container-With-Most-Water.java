class Solution {
    public int maxArea(int[] height) {
        
        int r=height.length-1;
        int pro=0,i=0;
        while(i<r)
        {
            pro=Math.max(pro,Math.min(height[i],height[r])*(r-i));

            if(height[i]<height[r]) 
            i++;
            else 
            r--;
        }
        return pro;
    }
}