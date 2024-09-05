import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
        public static long solution(int n, int[] works) {
        // 야근 피로도 = 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
        // 남은 수를 '제곱'해서 더하기 때문에 큰 수를 최대한 줄이는 것이 관건

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            q.offer(works[i]);
        }

        while(n>0){
            int work = q.poll();
             if(work == 0) break;
            work -= 1;
            q.offer(work);
            n -= 1;
        }
        
        //남은 피로도 계산
        long answer = 0;
        int qSize = q.size();
        for (int i = 0; i < qSize; i++) {
            answer += Math.pow(q.poll(), 2);
        }
        
        return answer;
    }
}