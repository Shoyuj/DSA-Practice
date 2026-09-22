class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []> q = new LinkedList<>();


        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || i==m-1 || j==0 || j==n-1) && grid[i][j]==1)
                {
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
                }
            }
        }

        int dir[][]={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        while(!q.isEmpty())
        {
            int cell[] = q.poll();
            int row = cell[0];
            int col=cell[1];

            for(int[] d : dir)
            {
                int newrow = row + d[0];
                int newcol = col + d[1];

                if(newrow<0 || newrow>m-1 || newcol<0 || newcol>n-1)
                continue;

                if(grid[newrow][newcol]==1)
                {
                    grid[newrow][newcol]=0;
                    q.offer(new int[]{newrow,newcol});
                }
            }
        }
        int ctr=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    ctr++;
                }
            }
        }
        return ctr;
    }
}