import java.util.*;

class Solution {
        public static int solution(int[][] triangle) {
        //두번째 줄부터 시작
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //왼쪽 끝일 때
                if(j == 0)
                    triangle[i][j] += triangle[i-1][j];
                //오른쪽 끝일 때
                else if(j == triangle[i].length-1)
                    triangle[i][j] += triangle[i-1][j-1];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        return answer;
    }
}