import java.util.*;

class Solution {
public static String solution(int[] numbers) {
    String[] s = new String[numbers.length];
    
    for(int i = 0; i < numbers.length; i++){
        s[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(s, (o1, o2) -> (o2+o1).compareTo(o1+o2));
    
    if(s[0].equals("0")) return "0";
    
    StringBuilder sb = new StringBuilder();
    for (String a : s) {
        sb.append(a);
    }
    
    return sb.toString();
    }
}