
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static int solution(String[][] book_time) {
        int answer = 0;  // 필요한 최소 객실 수를 저장할 변수

        // 예약 시간을 기준으로 오름차순 정렬 (시작 시간 기준)
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));

        // 우선순위 큐: 종료 시간을 기준으로 정렬하여, 가장 빨리 끝나는 예약을 확인함
        // 이미 사용 중인 대실들의 리스트 
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        // 예약 시간 순차적으로 처리
        for (String[] book : book_time) {
            // 시작 시간과 종료 시간을 각각 분으로 변환
            String[] starts = book[0].split(":");
            String[] ends = book[1].split(":");

            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);  // 시작 시간 (분 단위)
            int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10;   // 종료 시간 (분 단위) + 10분 청소 시간

            // 예약된 객실이 없는 경우, 새로운 객실을 할당
            if (pq.isEmpty()) {
                answer++;  // 새로운 객실 필요
                pq.offer(new int[]{start, end});  // 큐에 예약 추가
                continue;  // 다음 예약 처리로 이동
            }

            // 현재 사용 중인 객실 중 가장 빨리 끝나는 예약 확인
            int[] prev = pq.poll();
            int prevEnd = prev[1];    // 이전 예약의 종료 시간 + 청소 시간

            // 현재 예약 시작 시간이 이전 예약 종료 시간 이후일 경우, 같은 객실 사용 가능
            if (start >= prevEnd) {
                pq.offer(new int[]{start, end});  // 같은 객실로 현재 예약 추가
            } else {
                // 다른 객실이 필요함. 새로운 객실을 할당하고, 두 예약 모두 큐에 추가
                answer++;
                pq.offer(new int[]{start, end});  // 현재 예약 추가
                pq.offer(prev);  // 이전 예약도 다시 큐에 넣음
            }
        }

        return answer;  // 필요한 객실 수 반환
    }
}