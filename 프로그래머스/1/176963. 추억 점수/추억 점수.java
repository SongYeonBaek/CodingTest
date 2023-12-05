import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
       int[] answer = new int[photo.length];
        int t;
        for (int i = 0; i < photo.length; i++) {
            answer[i] = 0;
            for(String n : photo[i]){
                t = Arrays.asList(name).indexOf(n);
                if(t < 0) continue;
                answer[i] += yearning[t];
            }
        }
        return answer;
    }
}