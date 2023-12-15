class Solution {
    boolean visited[];
    int answer = 0;
    
    public void dfs(int n, int[][] computers, int i) {
        visited[i] = true;
        
        for(int j=0; j<n; j++) {
            if(!visited[j] && computers[i][j] == 1 && i != j) {
                dfs(n, computers, j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
}