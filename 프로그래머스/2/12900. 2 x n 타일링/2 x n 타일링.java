class Solution {
    public static int solution(int n) {
        int answer = 0;

        //가로길이가 i일 때, 타일링의 경우의 수는 = i-1의 경우의 수와 i-2의 경우의 수를 합한 것이다.
        //
        //i-1의 경우의 수에서 세로 타일을 붙임
        //
        //i-2의 경우의 수에서 가로 타일을 붙임

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }
}