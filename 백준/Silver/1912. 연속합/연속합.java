import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        int[] prefix = new int[n+1];
        int temp;
        int answer = -1000000001;

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            temp = Integer.parseInt(st.nextToken());
            prefix[i+1] = Math.max(prefix[i] + temp, temp);
            answer = Math.max(answer, prefix[i + 1]);
        }

        System.out.printf("%d", answer);
    }
}