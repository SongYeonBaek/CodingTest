class Solution {
    static boolean[] visited;
    
    public boolean dfs(int n, int[][] computers, int now){
        //방문 처리
        visited[now] = true;
        
        boolean flag = false;
        
        for(int i=0; i<n; i++){
            if(i != now && computers[now][i] == 1) {
                if(visited[i] == false) {
                    flag = true;
                    dfs(n, computers, i);
                }
            }
        }
        
        return flag;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i] == false) {
                answer++;
                dfs(n, computers, i);
                
            }
        }
        
        return answer;
    }
}
