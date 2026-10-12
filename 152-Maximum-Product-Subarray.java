
class Solution {
    public int maxProduct(int[] nums) {

        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int n = nums[i];

            if (n < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);

            max = Math.max(max, currMax);
        }

        return max;
    }
}
