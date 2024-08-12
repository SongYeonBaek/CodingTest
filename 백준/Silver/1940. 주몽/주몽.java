
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0; // 1번째 포인터
        int end =arr.length-1; //2번째 포인터
        int sum =0;// 1번째 포인터와 2번째 포인터를 더 한 값을 su와 비교
        int count = 0; // 몇번의 재료가 들어 갔는지 세는 변수

        while(start < end){ // start 포인터가 더 커진다면 종료
            sum =arr[start] + arr[end];
            if(sum < m){ // 1번째 조건 sum < su보다 더 큰가?
                // 8 < 9 비교 했을때 9가 더 크다면 start 포인터 한칸 앞으로
                start++;
            }else if(sum==m){ // 같으면 start 포인터와 end 포인터 한칸 씩
                start++;
                end--;
                count++;
            }else{ // 만약 sum > end가 더 크다면 end 포인터 값을 한칸 앞으로
                end--;
            }
        }

        System.out.println(count);
    }
}
