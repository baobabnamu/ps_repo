import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int sum = 0;
        int answer = 0;
        
        for(int n : d) {
            sum += n;
            if(sum <= budget) answer++;
        }
        
        return answer;
    }
}