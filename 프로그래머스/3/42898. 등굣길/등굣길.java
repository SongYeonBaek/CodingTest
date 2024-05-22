class Solution {
      public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] map = new int[n][m];


//        for (int i = 0; i < m; i++) {
//            map[0][i] = 1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            map[i][0] = 1;
//        }

        map[0][0] = 1;

        for(int[] i : puddles){
            map[i[1]-1][i[0]-1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == -1) continue;
                if(j>0) {
                    if (map[i][j - 1] > 0) map[i][j] += map[i][j - 1];
                }
                if(i>0) {
                    if (map[i - 1][j] > 0) map[i][j] += map[i - 1][j];
                }
                map[i][j] %= mod;
            }
        }


        return map[n-1][m-1];
    }
}