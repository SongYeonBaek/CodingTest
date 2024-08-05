
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sour, bitter;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int index, int sourProduct, int bitterSum) {
        if (index == n) {
            // If at least one food item is included (i.e., sourProduct should not be 1)
            if (sourProduct > 1) {
                min = Math.min(min, Math.abs(sourProduct - bitterSum));
            }
            return;
        }

        // Include the current index
        dfs(index + 1, sourProduct * sour[index], bitterSum + bitter[index]);

        // Exclude the current index
        dfs(index + 1, sourProduct, bitterSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sour = new int[n];
        bitter = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0); // Initial call to dfs with starting index, sourProduct as 1, and bitterSum as 0

        System.out.println(min);
    }
}
