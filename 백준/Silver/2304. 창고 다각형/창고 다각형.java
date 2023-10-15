import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
    //  좌탐, MAX, 우탐 각각 구해서 면적 더하기.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int[][] pillars = new int[N][2];
        int tall = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            pillars[i][0] = Integer.parseInt(st.nextToken());
            pillars[i][1] = Integer.parseInt(st.nextToken());
            tall = Math.max(pillars[i][1], tall);
        }

        Arrays.sort(pillars, Comparator.comparingInt(o->o[0]));

        int centerPillar = 0;
        // 제일 큰 값을 중간 값으로 지정
        for(int i = 0; i<N; i++) {
            if(pillars[i][1]==tall) centerPillar = i;
        }

        int size = tall; // 제일 큰 기둥 면적 값을 미리 누적
        int prevX = pillars[0][0]; // 제일 왼쪽에 있는 기둥
        int prevH = pillars[0][1];

        // 좌탐
        for(int i = 0; i<=centerPillar; i++) {
            // 이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if(pillars[i][1] >= prevH) {
                size += (pillars[i][0]-prevX)*prevH;
                // 비교 기둥 정보 업데이트
                prevX = pillars[i][0];
                prevH = pillars[i][1];
            }
        }

        prevX = pillars[N-1][0]; // 제일 오른쪽에 있는 기둥
        prevH = pillars[N-1][1];

        // 우탐
        for(int i = N-1; i>=centerPillar; i--) {
            //이전 기둥보다 큰 기둥이 나타나면 넓이 구하기
            if(pillars[i][1] >= prevH) {
                size += (prevX - pillars[i][0])*prevH;
                //현재 기둥 정보 갱신
                prevX = pillars[i][0];
                prevH = pillars[i][1];
            }
        }

        System.out.println(size);
    }
}