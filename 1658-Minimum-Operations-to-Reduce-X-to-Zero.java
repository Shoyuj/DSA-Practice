class Solution {
     public int minOperations(int[] nums, int x) {

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int sumToBeChecked = totalSum - x;
        if(sumToBeChecked == 0){
            return nums.length;
        }
        if (sumToBeChecked < 0) {
    return -1;
}
        

        int left = 0;
        int sum = 0;
        int longestSubarrayLength = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > sumToBeChecked) {
                sum -= nums[left];
                left++;
            }
            if(sum == sumToBeChecked) {
                longestSubarrayLength = Math.max(longestSubarrayLength,right-left+1);
            }
        }
        if(longestSubarrayLength  == 0) {
            return  -1;
        }
        return nums.length - longestSubarrayLength;
    }
}