class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n= costs.length;
        int sum=0;
        // int arr[]= new int[n];

        // for(int i=0;i<;i++)
        // {
        //     arr[i]=costs[i][0]-costs[i][1];
        // }

        Arrays.sort(costs,(a,b) -> a[0]-a[1]- (b[0]-b[1]));

        for(int i=0;i<n;i++)
        {
            if(i<n/2)
            sum+=costs[i][0];
            else
            sum+=costs[i][1];
        }
        
        return sum;
    }
}