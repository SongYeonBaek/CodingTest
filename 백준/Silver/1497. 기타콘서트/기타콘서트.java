import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, ans, ansG;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) == 'Y';
            }
        }
        subset(0, 0, new boolean[N]);
        System.out.println(ans == 0 ? -1 : ansG);
    }

    public static void subset(int dep, int guitar, boolean[] pick) {

        if (dep == N) {
            boolean[] song = new boolean[M];

            for (int i = 0; i < N; i++) {
                if (pick[i]) {
                    for (int j = 0; j < M; j++) {
                        if (arr[i][j]) song[j] = true;
                    }
                }
            }

            int now = 0;
            for (boolean b : song) if (b) now++;

            if (now == ans) {
                ansG = Math.min(ansG, guitar);
            } else if (now > ans) {
                ans = now;
                ansG = guitar;
            }

            return;
        }


        pick[dep] = true;
        subset(dep + 1, guitar + 1, pick);
        pick[dep] = false;
        subset(dep + 1, guitar, pick);
    }


}