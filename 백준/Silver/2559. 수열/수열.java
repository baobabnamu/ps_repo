import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] prefix = new int[N+1];
        for(int i=0; i<N; i++) prefix[i+1] = prefix[i] + Integer.parseInt(st.nextToken());

        int answer = -10000001;
        for(int i=K; i<=N; i++) {
            int rangeSum = prefix[i] - prefix[i-K];
            answer = Math.max(answer, rangeSum);
        }

        System.out.printf("%d", answer);
    }
}