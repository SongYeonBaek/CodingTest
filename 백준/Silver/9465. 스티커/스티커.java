
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[i][j] : i행 j열까지 스티커를 떼었을 때 얻을 수 있는 최대 점수
            int[][] dp = new int[2][n];

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            if (n > 1) {
                dp[0][1] = sticker[1][0] + sticker[0][1];
                dp[1][1] = sticker[0][0] + sticker[1][1];
            }

            for (int j = 2; j < n; j++) {
                // 윗 줄 - 현재 값 + 대각선 왼쪽 아래 또는 왼쪽 두 칸 아래에서 오는 최대값
                dp[0][j] = sticker[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);

                // 아랫 줄 - 현재 값 + 대각선 왼쪽 위 또는 왼쪽 두 칸 위에서 오는 최대값
                dp[1][j] = sticker[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
            }

            int max = Math.max(dp[0][n-1], dp[1][n-1]);
            System.out.println(max);
        }
    }
}
