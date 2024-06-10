import java.util.*;

class Solution {
public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : scoville) {
            pq.add(x);
        }

        int count = 0;
        while(pq.peek() < K){
            if(pq.size() == 1){
                return -1;
            }

            int n = pq.poll();
            int m = pq.poll();
            pq.add(n + m *2);
            count++;
        }
        return count;
    }
}