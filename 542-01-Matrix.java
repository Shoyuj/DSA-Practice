import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];

        // Add all zeros to the queue
        // Initialize other cells as unvisited (-1)
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
                else
                {
                    dist[i][j] = -1;
                }
            }
        }

        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!q.isEmpty())
        {
            // Remove the current cell once
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            // Check all four directions
            for(int[] d : dir)
            {
                int newrow = row + d[0];
                int newcol = col + d[1];

                // Check boundaries
                if(newrow < 0 || newrow >= m ||
                   newcol < 0 || newcol >= n)
                {
                    continue;
                }

                // Visit only unvisited cells
                if(dist[newrow][newcol] == -1)
                {
                    dist[newrow][newcol] =
                        dist[row][col] + 1;

                    q.offer(new int[]{newrow, newcol});
                }
            }
        }

        return dist;
    }
}