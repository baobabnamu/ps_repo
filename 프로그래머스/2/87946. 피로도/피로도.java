// DFS
// 최소 필요 피로도보다 높은 체력인 경우에만 던전 출입 가능
// 가능한 최대 던전 출입 횟수

class Solution {
    int fatigue;
    int[][] map;
    boolean[] visited;
    int answer = 0;
    
    public void dfs(int depth, int fatigue, boolean[] visited) {
//         depth는 depth마다 다른 카운트 값이다.
        
//         수행 동작
        for(int i=0; i<map.length; i++) {
//         방문한 적이 없으면서, 최소 필요 피로도 보다 높은 던전에 출입한다.
            if(!visited[i] && map[i][0] <= fatigue) {
//         방문한 던전을 체크한다.
                visited[i] = true;
//         출입한 던전의 소모 피로도만큼 피로도가 감소하고 depth에 1를 증가 시킨다.
                dfs(depth+1, fatigue-map[i][1], visited);
//         depth가 바뀌면(=다른 던전을 처음으로 입장하면) visited 값을 초기화 한다.
                visited[i] = false;
            }
        }
//         반복이 끝날 때마다 이전 depth의 카운트 값과 answer를 비교하고 더 큰 값이 answer에 저장된다.
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