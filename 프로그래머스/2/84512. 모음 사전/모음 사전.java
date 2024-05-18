import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();

    public void dfs(String[] s, String result, int length){
        if(result.length() == length) list.add(result);

        else{
            for (int i = 0; i < s.length; i++) {
                dfs(s, result + s[i], length);
            }
        }
    }

    public int solution(String word) {
        int answer = 0;

        String[] s = {"A", "E", "I", "O", "U"};

        for (int i = 1; i <= 5; i++) {
            dfs(s, "", i);
        }

//        System.out.println(list);

        Collections.sort(list);

//        System.out.println(list);

        return list.indexOf(word) + 1;
    }
}