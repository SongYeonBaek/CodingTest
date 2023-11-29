import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);
        for (int i =1; i < arr.length; i++) {
            if(arr[i] == s.peek()) continue;
            s.add(arr[i]);
        }
        return s;
    }
}