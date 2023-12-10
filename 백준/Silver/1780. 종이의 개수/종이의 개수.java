import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] count = {0,0,0};
    public static void dfs(int size, int x, int y){
        //만약 같은 숫자로만 이루어져 있다면: 해당 숫자 count 증가
        if(check(size, x, y)){
            if(map[y][x] == -1) count[0]++;
            else if(map[y][x] == 0) count[1]++;
            else count[2]++;
            return;
        }


        //가장 위에 3개
        dfs(size/3, x, y);
        dfs(size/3, x + size/3 , y);
        dfs(size/3, x+size/3*2, y);

        //2번째 줄 3개
        dfs(size/3, x, y+size/3);
        dfs(size/3, x+size/3, y+size/3);
        dfs(size/3, x+size/3*2, y+size/3);

        //3번재 줄 3개
        dfs(size/3, x, y+size/3*2);
        dfs(size/3, x+size/3, y+size/3*2);
        dfs(size/3, x+size/3*2, y+size/3*2);
    }

    public static boolean check(int size, int x, int y){
        int f = map[y][x];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(f != map[y+i][x+j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
//                System.out.print(map[i][j]+" ");
            }
//            System.out.println();
        }

        dfs(n, 0, 0);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}
