import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long left = 0; long right = (long) n * times[times.length-1];
        long answer = 0;
        
        while(left <= right){
            long tmp = (left+ right)/2;
            
            long count = 0;
            for(int i : times){
                count += tmp / i;
            }
            
            if(n <= count){
                answer = tmp;
                right = tmp - 1;
            }
            
            else {
                left = tmp + 1;
            }
        }
        
        return answer;
    }
}