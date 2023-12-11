class Solution {
    int target;
    int[] numbers;
    int answer;
    
    public void dfs(int index, int sum) {
// 종료조건
        if(index==numbers.length) {
            if(target==sum) answer++;
            return;
        }
        
// 수행동작
        dfs(index+1, sum+numbers[index]);
        dfs(index+1, sum-numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
}