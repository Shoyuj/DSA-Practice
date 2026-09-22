import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // 1. Add all rotten oranges to the queue
        //    and count fresh oranges
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        // Four possible directions
        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

        // 2. BFS
        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // Process all rotten oranges
            // present at the beginning of this minute
            for(int i = 0; i < size; i++) {

                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];

                // Check all four directions
                for(int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check boundaries
                    if(newRow < 0 || newRow >= m ||
                       newCol < 0 || newCol >= n) {
                        continue;
                    }

                    // Only rot fresh oranges
                    if(grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        fresh--;

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        // 3. If fresh oranges remain, they cannot rot
        if(fresh > 0)
            return -1;

        return minutes;
    }
}