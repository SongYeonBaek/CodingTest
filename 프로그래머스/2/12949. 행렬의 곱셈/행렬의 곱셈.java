class Solution {
        public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        // (3*2) * (2*2) = (3*2)

        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}