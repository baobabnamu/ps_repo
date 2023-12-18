import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer, rowSize, colSize;
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        rowSize = maps.length;
        colSize = maps[0].length;
        visited = new int[rowSize][colSize];
        
        bfs(maps);
        
        answer = visited[rowSize-1][colSize-1];
        
        return answer == 0 ? -1 : answer;
    }
    
    public void bfs(int[][] maps) {
        visited[0][0] = 1;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0));
        
        while(!que.isEmpty()) {
            Node curNode = que.poll();
            
            for(int i=0; i<4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < rowSize && ny < colSize && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[curNode.x][curNode.y] + 1;
                    que.offer(new Node(nx, ny));
                }
            }
        }
    }
}