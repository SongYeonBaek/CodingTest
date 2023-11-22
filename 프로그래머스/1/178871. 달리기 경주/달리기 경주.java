import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> hash = new HashMap<>();

        for(int i=0; i<players.length; i++){
	        hash.put(players[i], i);
        }
       
        int b, tmp;
        String p;
        for(String player : callings){
            //호출된 player의 인덱스(등수)를 저장
            b = hash.get(player);
            //호출된 player가 앞지른 player를 저장, 인덱스 저장
            p = players[b-1];
            tmp = hash.get(p);
            players[tmp] = player;
            players[tmp+1] = p;
            
            //hashMap도 갱신
            hash.put(player, b-1);
            hash.put(p, b);
        }
        
        return players;
    }
}