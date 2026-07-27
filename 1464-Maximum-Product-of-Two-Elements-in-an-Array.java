class Solution {
    public int maxProduct(int[] arr) {
        
        int l=0,sl=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>l)
            {
                sl=l;
                l=arr[i];
            }
            else if(arr[i]>sl)
            sl=arr[i];
        }

        return (sl-1)*(l-1);
    }
}