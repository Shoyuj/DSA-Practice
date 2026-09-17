class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;
        int temp;

        // Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If a valid index exists
        if (index != -1) {

            // Find the first number greater than nums[index]
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {

                    temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;

                    break;
                }
            }
        }

        // Reverse everything after index
        int left = index + 1;
        int right = n - 1;

        while (left < right) {

            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}