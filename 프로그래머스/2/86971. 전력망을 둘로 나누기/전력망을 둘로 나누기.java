class Solution {
    boolean[][] arr;
    boolean[] visited;
    
    public void getDividedTree(int n, int[][] wires, int ignoreNode) {
        for(int i=0; i<wires.length; i++) {
            if(i!=ignoreNode) {
                arr[wires[i][0]][wires[i][1]] = arr[wires[i][1]][wires[i][0]] = true;
            }
        }
    }
    
    public void dfs(int node) {
        visited[node] = true;
        for(int i=0; i<arr.length; i++) {
            if(!visited[i] && arr[node][i]) {
                dfs(i);
            }
        }
    }
    
    public int getVisitedCount() {
        int visitedCount = 0;
        for(boolean b : visited) {
            if(b) {
                visitedCount++;
            }
        }
        return visitedCount;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
//         간선을 하나씩 잘라보도록 순회
        for(int i=0; i<wires.length; i++) {
            arr = new boolean[n+1][n+1];
            visited = new boolean[n+1];
            
//         간선 자르기
            getDividedTree(n, wires, i);
            
//         잘라져있는 트리 탐색
            dfs(1);
            
//         한 쪽의 송전탑 묶음만 알아도 다른 쪽의 송전탑 수를 알 수 있음.
            int visitedCount = getVisitedCount();
            int diff = Math.abs(visitedCount - (n - visitedCount));
            
//         값 업데이트
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
}