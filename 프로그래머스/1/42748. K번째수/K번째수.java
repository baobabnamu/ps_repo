import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
//         1개의 array -> 여러 개의 commands -> 각 커맨드마다 결과 값을 배열에 담기
//         여러 개의 commands -> 한 개의 command -> 3개의 요소 (i, j, k) ->
//         i를 start로, j를 end로, k번째에 있는 수, 계산을 위한 임시 배열의 크기는 j-i+1 ->
//         array의 i부터 j까지 순회 후 임시 배열에 저장 -> 임시 배열 정렬 ->
//         정렬된 임시 배열의 k번째 수를 array에 저장  -> array의 크기는 commands[]의 크기이며 array 크기만큼 위 로직 반복
        
        int[] answer = new int[commands.length];
        
        for(int i=0; i<answer.length; i++) {
            int tempIndex = 0;
            int start = commands[i][0];
            int end = commands[i][1];
            int K = commands[i][2];
            int[] tempArr = new int[end-start+1];
            
            for(int j=start-1; j<end; j++)
                tempArr[tempIndex++] = array[j];
                
            Arrays.sort(tempArr);
            
            answer[i] = tempArr[K-1];
        }
        
        return answer;
    }
}