import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
//         진도, 속도
//         진도가 속도만큼 반복해서 증가 (반복횟수 = 일수), 앞 기능이 다 개발돼야 배포 가능.
//         다음 기능 건에 대하여 개발소요일수 값을 계산했을 때 이전 기능 개발 건의 개발소요일수보다 낮거나 같으면 같이 배포
        // add() / poll() 반환 후 제거, 비어있으면 NULL / remove() 제거 / clear() 초기화 / peek() 반환 / size()
        Queue<Integer> days = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int day = 0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }
            days.add(day);
        }
        
        ArrayList<Integer> deploysAL = new ArrayList<>();
        // 첫 번째 day 가져와서 자기보다 낮은 애들 개수 확인하고 그만큼 remove 
        int day = days.poll();
        int cnt = 1;
        while(days.size() > 0) {
            if(day >= days.peek()) {
                cnt++;
                days.remove();
            } else {
                deploysAL.add(cnt);
                day = days.poll();
                cnt = 1;
            }
            if(days.size() == 0) deploysAL.add(cnt);
        }
        
        int[] deploys = deploysAL.stream().mapToInt(x->x).toArray();
        return deploys;
    }
}