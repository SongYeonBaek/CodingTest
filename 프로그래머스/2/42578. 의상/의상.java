import java.util.*;

class Solution {
    public int solution(String[][] clothes) {HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String[] s : clothes){
            if(map.containsKey(s[1])) map.get(s[1]).add(s[0]);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s[0]);
                map.put(s[1], list);
            }
        }

        ArrayList<Integer> size = new ArrayList<>();
        for(String s : map.keySet()){
            size.add(map.get(s).size());
        }

        System.out.println(size);

        int count = 1;
        for (int s: size){
            count *=(s + 1);
        }
        return count-1;
    }
}