// DFS
// 최소 필요 피로도보다 높은 체력인 경우에만 던전 출입 가능
// 가능한 최대 던전 출입 횟수

class Solution {
    int fatigue;
    int[][] map;
    boolean[] visited;
    int answer = 0;
    
    public void dfs(int depth, int fatigue, boolean[] visited) {               
        if(map.length == answer) return; // 최대 횟수에 이미 도달했다면 더 이상 탐색 안함.
        
        for(int i=0; i<map.length; i++) {
            if(!visited[i] && map[i][0] <= fatigue) {
                visited[i] = true;
                dfs(depth+1, fatigue-map[i][1], visited);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    
    public int solution(int k, int[][] dungeons) {
        this.fatigue = k;
        this.map = dungeons;
        visited = new boolean[map.length];
        
        dfs(0, k, visited);
        
        return answer;
    }
}
