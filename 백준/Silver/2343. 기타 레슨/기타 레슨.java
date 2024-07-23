import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lect = new int[N];
        long sum = 0;
        long low = 0;  // should start from 0
        long high = 0;
        
        for (int i = 0; i < N; i++) {
            lect[i] = Integer.parseInt(st.nextToken());
            sum += lect[i];
            low = Math.max(low, lect[i]); // should be the max element in the array
        }

        high = sum; // this should be sum of all elements
        while (low <= high) {
            long mid = (low + high) / 2;
            int count = 1;
            long sumTime = 0;

            for (int i = 0; i < N; i++) {
                sumTime += lect[i];
                if (sumTime > mid) {
                    sumTime = lect[i];
                    count++;
                }
            }

            if (count <= M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
