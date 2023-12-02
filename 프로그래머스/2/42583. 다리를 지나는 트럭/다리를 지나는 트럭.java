import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int t : truck_weights) {
            while(true) {
                if(que.isEmpty()) {
                    que.offer(t);
                    sum += t;
                    answer++;
                    break;
                } else if(que.size() == bridge_length) {
                    sum -= que.poll();
                } else {
                    if(weight < sum+t) {
                        que.offer(0);
                        answer++;
                    } else {
                        que.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer+bridge_length;
    }
}