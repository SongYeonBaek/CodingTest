import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> duration = new ArrayList<>();
        double a;
        for (int i = 0; i < progresses.length; i++) {
            a = Math.ceil((double)( 100 - progresses[i]) / speeds[i]);
            duration.add((int) a);
        }

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count;

        for(int i : duration){
            if(queue.isEmpty() || i <= queue.peek()) {
                queue.offer(i);
            }

            else {
                count = 0;
                while (!queue.isEmpty()){
                    queue.poll();
                    count++;
                }
                answer.add(count);
                queue.offer(i);
            }
        }
        if(!queue.isEmpty()) {
            count = 0;
            while (!queue.isEmpty()) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
         return answer;
    }
}
    
