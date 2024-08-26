import java.util.Stack;

class Solution {
     public static int solution(String s) {
        int answer = 0;

        // x = 0 ~ (길이-1) 가 될 수 있음
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            //회전
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            //회전된 문자열에 대해 올바른 문자열인지 확인 -> Stack 이용
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                
                //stack의 비어있는 경우 : 넣어주기만 함
                if (stack.isEmpty()) {
                    stack.push(c);
                } 
                
                //닫는 괄호가 나올 때 -> 알맞은 짝이 있으면 pop!
                else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } 
                
                //닫는 괄호가 나왔는데 짝이 없는 경우 + 여는 괄호 나올 경우 -> push!
                else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}