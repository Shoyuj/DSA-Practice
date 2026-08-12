class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int l=0;
        int r=0;
        int result = 0;

        while(r<nums.length){
            countMap.put(nums[r], countMap.getOrDefault(nums[r] , 0)+1);
            if(countMap.get(nums[r]) >k){

                while(nums[l]!=nums[r]){
                    countMap.put(nums[l], countMap.getOrDefault(nums[l] , 0)-1);
                    l++;
                }
                countMap.put(nums[l], countMap.getOrDefault(nums[l] , 0)-1);
                l++;
            }

            result = Math.max(result, r-l+1);
            r++;
        }

        return result;
    }
}