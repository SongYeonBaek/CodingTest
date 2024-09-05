import java.util.Stack;
class Solution {
   public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();

        int p = 0;

        for (int i = 1; i <= order.length; i++) {
            //맞으면
            if(order[p] == i) {
                answer++;
                p++;
            }

            //아니면 보조에다 넣기
            else {
                sub.add(i);
            }

            while(!sub.isEmpty() && sub.peek() == order[p]) {
                sub.pop();
                answer++;
                p++;
            }
        }

        return answer;
    }
}