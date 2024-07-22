import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static long[] drink;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 주문한 막걸리 주전자 개수 (최대 1만이하)
        K = Integer.parseInt(st.nextToken()); // 친구들의 수 (100만이하)

        drink = new long[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            drink[i] = Long.parseLong(st.nextToken());
        }
    }

    static boolean isValid(long ml) {
        long cnt = 0;
        for(long d : drink) {
            cnt += (d / ml);
        }

        return cnt >= K;
    }

    static void pro() {
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        while(L <= R) {
            long mid = (L + R) / 2;
            if(isValid(mid)) { //최대 용량을 찾으므로 조건 성립시 L을 증가
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}