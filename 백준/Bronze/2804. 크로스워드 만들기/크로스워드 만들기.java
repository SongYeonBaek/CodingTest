
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void printCrossWord(String A, String B, int x, int y){
        for (int i = 0; i < B.length(); i++) {
            if(i == y) {
                System.out.println(A);
                continue;
            }
            for (int j = 0; j < A.length(); j++) {
                if(j == x) System.out.print(B.charAt(i));
                else System.out.print(".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        //두 단어가 시작할 인덱스 구하기
        int x, y;

        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if(A.charAt(i) == B.charAt(j)) {
                    printCrossWord(A, B, i, j);
                    return;
                }
            }
        }
    }
}
