import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];

            for(int i = 0; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for(int i = 1; i < N; i++){
                dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], i > 1 ? dp[1][i-2] : 0);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], i > 1 ? dp[0][i-2] : 0);
            }

            int max = Math.max(dp[0][N-1], dp[1][N-1]);
            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}
