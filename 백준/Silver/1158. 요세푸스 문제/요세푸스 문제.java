
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int p = 0;
        while (!list.isEmpty()) {
            p = (p + k - 1) % list.size();
            sb.append(list.remove(p)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // 마지막 ", "를 제거
        sb.append(">");

        System.out.println(sb.toString());
    }
}
