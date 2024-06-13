class Solution {
    static boolean[] visited;
    public static void dfs(int[][] computers, int x){
        visited[x] = true;

        for (int i = 0; i < computers.length; i++) {
            if(computers[x][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }

    }
    public static int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                count++;
            }
        }

        return count;
    }
}