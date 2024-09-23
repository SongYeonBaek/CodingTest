import java.util.LinkedList;
import java.util.Queue;

class Solution {
        static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    public static boolean bfs(int x, int y, String[] p){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                //* 시작지점이 아닌지 고려해줘야 함
                if(nx < 0 || ny < 0 || nx > 4 || ny >4 ||(nx == x && ny == y)) continue;

                int manhattan = Math.abs(nx - x) + Math.abs(ny - y);

                if (p[nx].charAt(ny) == 'P' && manhattan <= 2) {
                    return false;
                }

                else if (p[nx].charAt(ny) == 'O' && manhattan < 2) {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return true;
    }


    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        //5번의 테스트케이스
        for (int i = 0; i < 5; i++) {
            String[] p = places[i];

            //2차원 배열을 돌면서 'P'가 나왔을 때 bfs를 진행
            //틀린게 하나라도 있으면 반복문을 끝내기 위해 flag값을 설정
            boolean flag = false;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (flag) break;

                    if (p[j].charAt(k) == 'P') {
                        if (!bfs(j, k, p)) {
                            flag = true;
                        }
                    }
                }
            }
            answer[i] = flag ? 0 : 1;
        }
        return answer;
    }


}