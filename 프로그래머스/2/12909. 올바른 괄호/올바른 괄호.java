import java.util.*;

class Solution {
    boolean solution(String s) {
// 여는 괄호를 만나면 stack 삽입, 닫는 괄호를 만나면 stack 추출
// stack size 크기 0이면 true, 0이 아니라면 false
        // )))()
        // ())(()

        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        
        for(char c : charArr) {
            if(stack.size() == 0 && c==')') return false;
            else if(c=='(') stack.push(c);
            else if(stack.size() > 0) stack.pop();
        }
        
        return stack.size() == 0 ? true : false;
    }
}