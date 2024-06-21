import java.util.*;

class Solution {
static int N; // 주사위의 수
    static List<Integer> choice = new ArrayList<>(); // 선택된 주사위의 인덱스를 저장할 리스트
    static int[][] dices; // 주사위들의 면값을 저장할 2차원 배열
    static List<Integer> arrA; // 첫 번째 그룹의 모든 합 경우의 수를 저장할 리스트
    static List<Integer> arrB; // 두 번째 그룹의 모든 합 경우의 수를 저장할 리스트
    static int[] answer; // 정답을 저장할 배열
    static int max = Integer.MIN_VALUE; // 최대 승리 횟수를 저장할 변수

    // 주어진 주사위 조합에 대해 모든 합 경우의 수를 계산하여 리스트에 저장하는 함수
    public static void makeArr(int depth, int[][] dice, int sum, List<Integer> arr) {
        if (depth == N / 2) { // 주사위 N/2개 선택한 경우
            arr.add(sum); // 합을 리스트에 추가
            return;
        }
        for (int i = 0; i < 6; i++) { // 각 주사위의 면(1~6) 선택
            int newSum = sum + dice[depth][i];
            makeArr(depth + 1, dice, newSum, arr);
        }
    }

    // 선택된 주사위를 기반으로 두 그룹으로 나누어 각각의 모든 합 경우의 수를 계산하는 함수
    public static void makeArrAB() {
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        int[][] diceA = new int[N / 2][6];
        int[][] diceB = new int[N / 2][6];
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) { // 두 그룹으로 나누기
            if (choice.contains(i)) { // choice 리스트에 포함된 인덱스는 그룹 A에 추가
                diceA[a] = dices[i];
                a++;
            } else { // 나머지는 그룹 B에 추가
                diceB[b] = dices[i];
                b++;
            }
        }

        makeArr(0, diceA, 0, arrA); // 그룹 A의 모든 합 경우의 수 계산
        makeArr(0, diceB, 0, arrB); // 그룹 B의 모든 합 경우의 수 계산
    }

    // 그룹 A와 B의 합 경우의 수를 비교하여 승리 횟수를 계산하는 함수
    public static int calculateWinningPercent() {
        int count = 0;

        makeArrAB(); // arrA와 arrB에 모든 경우의 수 저장

        Collections.sort(arrB); // 이분 탐색을 위해 arrB 정렬
        for (int i = 0; i < arrA.size(); i++) {
            int number = arrA.get(i);

            int left = 0, right = arrB.size() - 1;

            int index = Integer.MIN_VALUE;
            while (left <= right) {
                int middle = (left + right) / 2;

                if (arrB.get(middle) < number) { // number 보다 작은 값 찾기
                    left = middle + 1;
                    index = Math.max(index, middle);
                } else {
                    right = middle - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                count += index + 1; // 작은 값의 개수 추가
            }
        }
        return count;
    }

    // 주사위 조합을 선택하여 최대 승리 횟수를 찾는 함수
    public static void choiceDice(int depth, int s) {
        if (depth == N / 2) { // N/2개의 주사위를 선택한 경우
            int winning = calculateWinningPercent(); // 승리 횟수 계산
            if (max < winning) { // 최대 승리 횟수 갱신
                max = winning;
                for (int i = 0; i < choice.size(); i++) {
                    answer[i] = choice.get(i) + 1; // 선택된 주사위 인덱스 저장
                }
            }
            return;
        }
        for (int i = s; i < N; i++) { // 주사위 선택
            choice.add(i);
            choiceDice(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }

    // 주어진 주사위 배열로부터 최대 승리 횟수를 갖는 주사위 조합을 찾는 함수
    public static int[] solution(int[][] dice) {
        N = dice.length; // 주사위의 개수
        dices = dice; // 주사위 배열 저장
        answer = new int[N / 2]; // 정답 배열 초기화
        choiceDice(0, 0); // 주사위 조합 선택 시작
        return answer;
    }

}