import java.util.*;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            // default Value가 0이 아니라 1인 이유 : 아무것도 착용하지 않는 경우의 수를 Value에 저장
            map.put(type, map.getOrDefault(type, 1) + 1);
        }
    
        for (String key : map.keySet())
            answer *= map.get(key);

        return answer-1;
    }
}