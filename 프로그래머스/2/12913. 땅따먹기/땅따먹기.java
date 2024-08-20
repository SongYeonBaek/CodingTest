class Solution {
    public static int solution(int[][] map)
    {
        int answer = 0;
        for (int i = 1; i < map.length ; i++) {
            map[i][0] += Math.max(map[i-1][1], Math.max(map[i-1][2], map[i-1][3]));
            map[i][1] += Math.max(map[i-1][0], Math.max(map[i-1][2], map[i-1][3]));
            map[i][2] += Math.max(map[i-1][0], Math.max(map[i-1][1], map[i-1][3]));
            map[i][3] += Math.max(map[i-1][0], Math.max(map[i-1][1], map[i-1][2]));
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, map[map.length-1][i]);
        }

        return answer;
    }
}