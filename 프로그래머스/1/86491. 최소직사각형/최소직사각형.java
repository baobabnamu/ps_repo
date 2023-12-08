import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW=0;
        int maxH=0;
        
        for(int i=0; i<sizes.length; i++){
            // 모든 명함을 더 긴 길이의 모서리를 가로로 눕히기
            int w=Math.max(sizes[i][0], sizes[i][1]);
            int h=Math.min(sizes[i][0], sizes[i][1]);
            
            // 그 중에서 가장 큰 크기가 곧 지갑의 크기
            maxW=Math.max(maxW, w);
            maxH=Math.max(maxH, h);
        }
        
        return maxW*maxH;
    }
}
