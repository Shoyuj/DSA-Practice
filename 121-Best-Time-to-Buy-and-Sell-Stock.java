class Solution {
    public int maxProfit(int[] prices) {
        
        int lo=prices[0],hi=0,pro=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<lo)
            lo=prices[i];

            pro=Math.max(pro,prices[i]-lo);
        }
        return pro;
    }
}