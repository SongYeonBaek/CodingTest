import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> des = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> asc = new PriorityQueue();

        for(String s : operations){
            String j = s.split(" ")[0];
            Integer v = Integer.parseInt(s.split(" ")[1]);

            if(j.equals("I")) {
                des.offer(v);
                asc.offer(v);
            }

            //D 일 때 - 삭제 연산
            else {
                //안해주면 null 포인터 에러 뜸
                if(des.isEmpty()) continue;

                //최솟값 삭제
                else if(v < 0) {
                    int min = asc.poll();
                    des.remove(min);
                }

                //최댓값 삭제
                else{
                    int max = des.poll();
                    asc.remove(max);
                }
            }
        }

        if(des.isEmpty())
            return new int[] {0, 0};

        if(des.size() > 0) {
            answer[0] = des.poll();
            answer[1] = asc.poll();
        }
        

        return answer;
    }
}