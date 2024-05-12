import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        // System.out.println(pq);
        
        Integer a, b;
        while(pq.peek() < K && pq.size() >= 2){
            if(pq.peek() < K) {
                a = pq.remove();
                b = pq.remove();
                pq.add(a + 2*b);
            
                answer++;
            }   
        }
        
        if(pq.size() == 1 && pq.peek() < K) return -1;
        
        else return answer;
    }
}