
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long count = 0;  // count를 long으로 변경하여 오버플로우 방지
        String num = "";
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            // 알파벳인 경우
            if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
                if (!num.equals("") && num.length() <= 6) {
                    count += Long.parseLong(num);
                }
                num = "";
            } else {
                // 숫자라면
                num += c;
            }
        }

        // 마지막 숫자를 처리
        if (!num.equals("") && num.length() <= 6) {
            count += Long.parseLong(num);
        }

        System.out.println(count);
    }
}
