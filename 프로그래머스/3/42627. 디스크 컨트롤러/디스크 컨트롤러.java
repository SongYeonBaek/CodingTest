import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        ArrayList<Integer> list = new ArrayList<>();

        //요청 시각으로 정렬
        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        int count = 0;
        // list.add(jobs[0][1]);
        int idx=0;

        while(list.size() < jobs.length){
            while(idx < jobs.length && count >= jobs[idx][0]){
                pq.offer(jobs[idx]);
                idx++;
            }

            //pq가 비어있고, 아직 처리되어야 하는 요청이 남아있지만 들어오지 않은 상태
            if(pq.isEmpty()){
                count = jobs[idx][0];
            }
            else {
                int[] i = pq.poll();
                count += i[1];
                System.out.println(count);
                list.add(count - i[0]);
            }
        }

//        System.out.println(list);

        int avg = 0;
        for(int i : list){
            avg += i;
        }

         return (int) Math.floor(avg/list.size());
    }
}