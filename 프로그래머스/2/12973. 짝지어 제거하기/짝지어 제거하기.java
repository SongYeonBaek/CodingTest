import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            //스택이 비어있으면 현재 위치 문자 넣어주기
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            }

            //스택이 비어있지 않고
            else {
                //스택 맨 위와 현재 위치 문자가 같을 때 = 제거
                if(stack.peek() == s.charAt(i)) {
                    stack.pop();
                }

                //같지 않다면 스택에 현재 위치 문자 넣어주기
                else {
                    stack.push(s.charAt(i));
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}