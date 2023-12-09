import java.util.*;
class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];     
        int total = brown+yellow;
        
        // 세로가 3보다 작다면 노란 블록의 공간이 없음
        for(int i=3; i<=total; i++) {
            if(total%i==0) { // 맵이 만들어지는 경우의 수라면 
                int col = i;
                int row = total/col;
                
                // 세로가 가로보다 큰 경우 continue
                if(col > row) continue;
                
                // 상, 하 감싸고 있는 갈색 블록 2개를 제외한 값이 노란 블록의 row 값
                // 좌, 우 감싸고 있는 갈색 블록 2개를 제외한 값이 노란 블록의 col 값
                // 노란 블록의 넓이는 row*col
                int inside_block = (row-2)*(col-2);
                // 만약 inside_block이랑 현재 맵의 경우의 수와 동일하다면 정답
                if(inside_block == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }      
        
        return answer;
    }
}