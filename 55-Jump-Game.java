class Solution {
    public boolean canJump(int[] nums) {
        
        int jump=nums[0];

        for(int i=1;i<nums.length;i++)
        {

            if(i>jump)
            return false;

            jump = Math.max(jump,i+nums[i]);
            
        }
        return true;
    }
}