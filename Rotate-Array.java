1class Solution {
2    public void rotate(int[] nums, int k) {
3        int l= nums.length;
4        k = k%l;
5        rotate(0,l-1,nums);
6        rotate(0,k-1,nums);
7        rotate(k,l-1,nums);
8        
9    }
10
11    void rotate(int left,int right, int[] arr)
12    {
13        while (left<=right)
14        {
15            int temp = arr[left];
16            arr[left] = arr[right];
17            arr[right] = temp;
18            left++;
19            right--;
20        }
21    }
22}