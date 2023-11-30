import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 참가자 배열 순회 > key로 저장 및 value 값 1 증가 > 완주자 배열 순회 > value 값 1씩 하락 > value 값이 1이상인 참가자 반환
        
        HashMap<String, Integer> map = new HashMap();
        String answer = "";
        
        for(String str : participant) 
            map.put(str, map.getOrDefault(str, 0)+1);
        
        
        for(String str : completion)
            map.put(str, map.get(str)-1);
        
        for(String str : participant) {
            if(map.get(str) >= 1) answer = str;
            // System.out.printf("%s %d, ", str, map.get(str));
        }
        
        return answer;
    }
}