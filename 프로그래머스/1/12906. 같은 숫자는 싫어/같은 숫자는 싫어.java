import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
//         0~9 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
//         이때 배열 순서는 유지
        
//         peek() - top 조회, push() - 삽입, pop() - 꺼내기, size() - 크기
//         이전 데이터와 동일하면 push X, 다른 경우에만 push
        Stack<Integer> stack = new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--) {
            if(stack.size() == 0) stack.push(arr[i]);
            if(stack.size() > 0 && stack.peek() != arr[i]) 
                stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        
        for(int i=0; i<answer.length; i++)
            answer[i] = stack.pop();
        
        return answer;
    }
}