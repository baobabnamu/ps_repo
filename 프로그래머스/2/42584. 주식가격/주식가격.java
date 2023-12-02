import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> que = new LinkedList<>();
        int[] answer = new int[prices.length];
        int idx = 0;
        
        for(int i : prices) que.offer(i);
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int i=(prices.length-que.size()); i<prices.length; i++) {
                if(cur <= prices[i]) {
                    answer[idx]++;
                } else {
                    answer[idx]++;
                    break;
                }
            }
            idx++;
        }
        
        return answer;
    }
}