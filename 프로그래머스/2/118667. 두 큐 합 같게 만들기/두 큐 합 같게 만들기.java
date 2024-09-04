
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        //주어진 배열을 큐로 바꾸기
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        //모든 원소의 합
        long sum = 0;
        //Queue1의 원소의 합
        long sumQ1 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum += queue1[i] + queue2[i];
            sumQ1 += queue1[i];
        }

        while(true){
            //불가능한 경우
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;
            }

            //두 큐의 합이 같으면 break
            if(sumQ1 == sum - sumQ1) break;

            //Queue1의 합이 Queue2보다 클 때
            else if (sumQ1 > sum-sumQ1) {
                //Queue1 pop해서 Queue2에 넣어주기
                sumQ1 -= q1.peek();
                q2.add(q1.poll());
            }

            //Queue2의 합이 Queue1보다 클 때
            else if(sumQ1 < sum-sumQ1){
                //Queue2 pop해서 Queue1에 넣어주기
                sumQ1 += q2.peek();
                q1.add(q2.poll());
            }

            answer++;

        }

        return answer;
    }

}