import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 내림차순 우선순위 큐 생성
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        // 우선순위 큐에 요소 추가
        for(int p : priorities)
            que.offer(p);
        
        // 큐가 빌 때까지 반복
        while(!que.isEmpty()) {
            // 우선순위 배열 인덱스 순회
            for(int i=0; i<priorities.length; i++) {
                // 우선순위 큐의 값과 우선순위 배열 순회 중 값이 동일한 경우
                if(que.peek() == priorities[i]) {
                    que.poll();
                    answer++; // 우선순위 카운팅

                    // 만약 비교할 프로세스의 위치값과 동일한 경우 카운팅한 값 반환
                    if(location == i) return answer;
                }
            }
        }
        return answer;
    }
}