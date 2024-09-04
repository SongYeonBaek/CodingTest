import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
       public static int solution(int x, int y, int n) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();

                if(p == y){
                    return answer;
                }

                if( p + n <= y && !visited.contains(p + n)){
                    queue.add(p + n);
                    visited.add(p + n);
                }

                if( p * 2 <= y && !visited.contains(p * 2)){
                    queue.add(p * 2);
                    visited.add(p * 2);
                }

                if( p * 3 <= y && !visited.contains(p * 3)){
                    queue.add(p * 3);
                    visited.add(p * 3);
                }
            }

            answer++;

        }

        return -1;
    }
}