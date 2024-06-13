class Solution {
    static int count = 0;
    public static int solution(int[] numbers, int target) {
        dfs(numbers,target, numbers[0], 1);
        dfs(numbers, target, -numbers[0], 1);

        return count;
    }

    public static void dfs(int[] numbers, int target, int result, int depth){
        if(depth == numbers.length - 1){
            if (result + numbers[depth] == target || result - numbers[depth] == target) {
                count++;
                return;
            }
        }

        else {
            dfs(numbers, target, result - numbers[depth], depth + 1);
            dfs(numbers, target, result + numbers[depth], depth + 1);
        }
    }
}