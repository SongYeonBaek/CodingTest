class Solution {
    public static int solution(int storey) {
        int answer = 0; // 마법의 돌을 사용하는 횟수를 저장하는 변수

        // 자릿수를 하나씩 확인하여 0으로 만들기
        while (storey > 0) {
            int num = storey % 10; // 현재 자릿수(1의 자리) 추출            
            storey /= 10; // 현재 자릿수를 제거한 나머지 숫자로 갱신

            if (num > 5) { // 자릿수가 6 이상이면 올림이 더 유리 (10에서 빼는 것이 이득)
                answer += 10 - num; // 올림 후 남은 차이만큼 마법의 돌 사용
                storey++; // 올림했으므로 다음 자릿수에서 +1

            } else if (num < 5) { // 자릿수가 4 이하이면 내림이 더 유리
                answer += num; // 해당 자릿수만큼 마법의 돌 사용

            } else if (storey % 10 >= 5) { // 자릿수가 5일 경우, 다음 자릿수가 5 이상이면 올림이 더 유리
                answer += 5; // 5만큼 마법의 돌 사용
                storey++; // 올림했으므로 다음 자릿수에서 +1

            } else { // 자릿수가 5이지만, 다음 자릿수가 4 이하인 경우 내림이 더 유리
                answer += 5; // 5만큼 마법의 돌 사용 (내림)
            }
        }

        return answer; // 마법의 돌을 최소로 사용한 횟수 반환
    }
}