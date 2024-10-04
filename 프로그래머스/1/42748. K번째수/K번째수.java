import java.util.*;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        int i = 0;
        for(int[] command : commands) {
            int[] list  = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(list);
            result[i] = list[command[2]-1];
            i++;
        }
        return result;
    }

}