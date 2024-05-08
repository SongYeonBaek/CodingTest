class Solution {
    public Integer[] solution(int[] prices) {
        Integer[] results = new Integer[prices.length];
        Integer count;
        Integer f;

        for (int i = 0; i < prices.length; i++) {
            f = prices[i];
            count = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(f <= prices[j]) count++;
                else {
                    count += 1;
                    break;
                }
            }
            results[i] = count;
        }

        return results;
    }
}