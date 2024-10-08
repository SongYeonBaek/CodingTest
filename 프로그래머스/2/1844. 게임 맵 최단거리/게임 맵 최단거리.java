import java.util.*;

class Solution {
    static int answer;
    
    public void bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<Integer[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Integer[]{0, 0, 1});
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1 , 0, 0};
        
        while(!q.isEmpty()){
            Integer[] a = q.poll();
            
            if(a[0] == n-1 && a[1] == m-1) {
                answer = Math.min(answer, a[2]);
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + a[0];
                int ny = dy[i] + a[1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(maps[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.offer(new Integer[]{nx, ny, a[2]+1});
                }
            }
            
        }
        
    }
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        
        bfs(maps);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}