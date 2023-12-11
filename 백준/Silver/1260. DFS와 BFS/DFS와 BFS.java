import java.io.*;
import java.util.*;

public class Main {
    final static int MAX = 1000+10;
    static boolean[][] graph;
    static boolean[] visited;

    static ArrayList<Integer> que;
    static int N, M, V;
//    N = 정점 개수, M = 간선 개수, V = 탐색 시작할 정점 번호
//    정점 번호(1~N)가 작은 것부터 방문, 두 정점 사이 여러 개의 간선 가능, 간선은 양방향

    public static void bfs() {
        que = new ArrayList<>();
        visited = new boolean[MAX];

        que.add(V);
        visited[V] = true;

        while(!que.isEmpty()) {
            int index = que.remove(0);
            System.out.printf("%d ", index);
            for(int i=1; i<=N; i++) {
                if(!visited[i] && graph[index][i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    public static void dfs(int index) {
        System.out.printf("%d ", index);
        visited[index] = true;
        for(int i=1; i<=N; i++) {
            if(!visited[i] && graph[index][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

//        Graph 입력
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

//        dfs
        dfs(V);
        System.out.println();

//        bfs
        bfs();
    }
}