import java.util.Arrays;
class Solution {
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(B);
        //어짜피 A의 순서도 상관 없음
        Arrays.sort(A);

        // 1,3,5,7   |  2,2,6,8
        int aPos = 0, bPos = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[aPos] >= B[bPos]) {
                bPos++;
            }
            else {
                aPos++;
                bPos++;
                answer++;
            }
        }

        return answer;
    }
}