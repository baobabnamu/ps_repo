import java.util.*;

class Solution {
    public int solution(int[] citations) {
//         N편 중 H번이상 인용된 논문이 H편 이상일 때 최댓값이 H-INDEX 값
        
        ArrayList<Integer> intAL = new ArrayList<>();
        int answer = 1;
        int cnt;
        
        for(int c : citations)
            intAL.add(c);
            
//         내림차순 정렬 후 citations 배열 순회하면서 H보다 큰 요소들만 카운트
        Collections.sort(intAL, Collections.reverseOrder());
        
//         1) 카운트 값이 H 보다 크거나 같은 경우 -> H + 1
//         2) 카운트 값이 H 보다 작은 경우 -> H - 1 후 break
        while(true) {
            cnt = 0;
            
            for(int i : intAL)
                if(i>=answer) cnt++;
            
            if(cnt >= answer) {
                answer++;
            }
            else {
                answer--;
                break;
            }
        }
        
        return answer;
    }
}