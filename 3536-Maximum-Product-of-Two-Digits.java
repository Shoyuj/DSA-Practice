class Solution {
    public int maxProduct(int n) {
        
        int pro=1,d=0,l=0,sl=0;
        while(n>0)
        {
            d=n%10;
            if(d>=l)
            {
                sl=l;
                l=d;
            }
            else if(d>sl){
                sl=d;
            }

            n/=10;
        }
        return l*sl;
    }
}