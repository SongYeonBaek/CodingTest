import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;

    public void dfs(String numbers, String s, int depth){
        if (depth > numbers.length()) {
            return;
        }

        else {
            for (int i = 0; i < numbers.length(); i++) {
                if(!visited[i]){
                    visited[i] = true;
                    set.add(Integer.parseInt(s + numbers.charAt(i)));
                    dfs(numbers, s + numbers.charAt(i), depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    public boolean isPrime(int n){
        if(n < 2) return false;
        else {

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }

            return true;
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        dfs(numbers, "", 0);

        // System.out.println(set);

        for (int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
}