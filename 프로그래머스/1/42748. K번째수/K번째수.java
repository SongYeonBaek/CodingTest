import java.util.*;

class Solution {
    public static ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] command : commands){
            int[] copy = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(copy);
            result.add(copy[command[2]-1]);
        }
        
        return result;
    }

}