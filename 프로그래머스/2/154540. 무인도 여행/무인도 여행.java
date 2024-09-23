
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> answer;
    static char[][] map;
    static boolean[][] visited;
    static int count;

    public static void dfs(int x, int y){
        visited[x][y] = true;
        count += map[x][y] - '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위 벗어날 때
            if(nx<0 || ny< 0 || nx >= map.length || ny >= map[0].length) continue;

            if(map[nx][ny] != 'X' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    public static List<Integer> solution(String[] maps) {
        answer = new ArrayList<>();

        map = new char[maps.length][maps[0].length()];

        //입력값 2차원 배열로 저장
        for(int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        visited = new boolean[maps.length][maps[0].length()];
        count = 0;
        for(int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++) {
                if(map[i][j] != 'X' && !visited[i][j]){
                    dfs(i, j);
                    answer.add(count);
                    count = 0;
                }

            }
        }

        if(answer.isEmpty()) {
            answer.add(-1);
        }
        Collections.sort(answer);

        return answer;
    }
}