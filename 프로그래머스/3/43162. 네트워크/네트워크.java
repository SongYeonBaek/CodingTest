class Solution {
    static int[] visited;

    public void dfs(int i, int[][] computers){
        visited[i] = 1;
        for (int j = 0; j < computers.length; j++) {
            if(computers[i][j] == 1 && visited[j] == 0){
                dfs(j, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for (int i = 0; i < computers.length; i++) {
            if(visited[i] == 0){
                answer++;
                dfs(i, computers);
            }
        }

        return answer;
    }
}