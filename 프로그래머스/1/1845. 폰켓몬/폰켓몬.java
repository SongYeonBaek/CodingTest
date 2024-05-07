import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums){
            if(hm.containsKey(i))
                hm.replace(i, hm.get(i)+1);

            else
                hm.put(i, 1);
        }

        int n = nums.length/2;

        //골라야하는 포켓몬 수보다 종류가 같거나 적을 때
        if(hm.size() >= n){
            return n;
        }

        //골라야하는 포켓몬 수가 종류보다 많을 때
        else{
            return hm.size();
        }
    }
}