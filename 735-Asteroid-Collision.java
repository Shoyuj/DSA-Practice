class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        boolean flag = true;
        for(int i =0 ; i<asteroids.length;i++)
        {
            flag= true;
                while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0 && flag)
                {
                    if(st.peek()<asteroids[i]*-1)
                    {
                        st.pop();
                    }
                    else if(st.peek()==asteroids[i]*-1)
                    {
                        st.pop();
                        flag = false;
                    }
                    else
                    flag=false;
                    
                }
            if(flag)    
            st.push(asteroids[i]);
        }

        int res[] = new int[st.size()];

        for(int i=res.length-1;i>=0;i--)
        {
            res[i]=st.pop();
        }

        return res;
    }
}