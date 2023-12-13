import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> list;
    static boolean[] visited;

    public static void recur(int depth) {
        if(depth == M) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            list.add(i);

            recur(depth + 1);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new boolean[N+1];

        recur(0);
    }
}

