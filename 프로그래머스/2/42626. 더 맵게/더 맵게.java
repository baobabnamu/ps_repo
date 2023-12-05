import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
//         섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//         모든 음식의 스코빌 지수가 K 이상이 될때까지 반복하며 그 횟수를 누적 -> 누적횟수=답
//         최소 힙에 데이터 넣어서 정렬 
//         최악으로 안 매운 음식과 차악으로 안 매운 음식을 poll() 한 뒤 공식 계산
//         위를 반복하되 경우의 수가 2개 있음
//         1) 최악 스코빌 지수가 K 이상이 된 경우 -> break 한 후 누적횟수 반환
//         2) 스코빌 지수가 K 이상으로 만들 수 없는 경우 -> -1 반환
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int s : scoville) que.offer(s);
        
        int firWorst = 0;
        int secWorst = 0;
        int newScoville = 0;
        while(K > que.peek()) {
            if(que.size() == 1) return -1;
            firWorst = que.poll();
            secWorst = que.poll();
            newScoville = firWorst + (secWorst*2);
            que.offer(newScoville);
            answer++;
        }
        
        return answer;
    }
}