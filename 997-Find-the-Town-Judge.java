
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] edge : trust) {

            int u = edge[0];
            int v = edge[1];

            score[u]--;
            score[v]++;
        }

        for (int i = 1; i <= n; i++) {

            if (score[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}