import java.util.*;

class Solution {
 public static int solution(int[] citations) {
        Arrays.sort(citations);
    
        int h=0;
        for (int i = 0; i < citations.length; i++) {
            int discussionCount = citations.length - i;

            if (citations[i] >= discussionCount) {
                h = discussionCount;
                break;
            }
        }
        return h;
    }

}