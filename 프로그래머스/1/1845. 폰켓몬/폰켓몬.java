import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // N 마리 중 N/2 마리를 고를 수 있는데, 이때 최대한 다양한 종류를 고르도록 해라.
        // K(종류), V(개수) 자료구조 생성
        // K의 개수(종류) 구하기
        // N/2 <= K 라면 N/2 값 반환, N/2 > K 라면 K 값 반환
        
        HashMap<Integer, Integer> map = new HashMap();
        int answer = 0;
        
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0)+1);
        
        answer = nums.length/2 <= map.size() ? nums.length/2 : map.size();
        
        return answer;
    }
}