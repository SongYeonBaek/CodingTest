import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    
    public void dfs(String target, String[] words, int now, int depth){
        //탈출 조건
        if(words[now].equals(target)) {
            answer = Math.min(answer, depth);
            System.out.print(depth);
            return;
        }
        
        if(depth > words.length) return;
        
        visited[now] = true;
        
        for(int i=0; i<words.length; i++){
            if(now == i) continue;
            if(check(words[i], words[now]) && visited[i] == false){
                // System.out.print(words[i]);
                dfs(target, words, i, depth+1);
                visited[i] = false;

            }
        }
        
    }
    
    public boolean check(String a, String b){
        int count = 0;
    
        for(int i =0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        
        return count == 1?true :false;
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        for(int i=0; i<words.length; i++){
            if(check(words[i], begin)){
                // System.out.print(words[i]);
                dfs(target, words, i, 1);
                
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}