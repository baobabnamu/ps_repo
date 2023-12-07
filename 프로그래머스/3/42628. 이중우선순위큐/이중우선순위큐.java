import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
//         명령어에 따라 경우의 수는 3개로 구분됩니다.
//         I 숫자 : 큐에 주어진 숫자를 최소힙, 최대힙에 둘 다 저장합니다.
//         D 1 : 최대힙에서 첫 번째 요소를 삭제하고, 최소힙에서 최대힙에서 삭제한 요소를 삭제합니다.
//         D -1 : 최소힙에서 첫 번째 요소를 삭제하고, 최대힙에서 최소힙에서 삭제한 요소를 삭제합니다.
//         이때, 빈 큐에 데이터를 삭제하는 경우 해당 연산을 무시합니다.
//         또한, 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우 하나만 삭제합니다.

//         명령어를 모두 수행한 이후에 반환 값의 경우의 수는 2개입니다.
//         1) 큐가 비어있는 경우 : [0, 0]을 반환합니다.
//         2) 큐가 안 비어있는 경우 : [최댓값, 최솟값]을 반환합니다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations) {
            String[] operation = o.split(" ");
            char sign = operation[0].charAt(0);
            int value = Integer.valueOf(operation[1]);
            
            if(sign == 'I') {
                minHeap.offer(value);
                maxHeap.offer(value);
            } 
            else if(sign == 'D') {
                if(minHeap.isEmpty() || maxHeap.isEmpty()) continue;
                else if (value == 1) {
                    int removeEl = maxHeap.poll();
                    minHeap.remove(removeEl);
                } 
                else if(value == -1) {
                    int removeEl = minHeap.poll();
                    maxHeap.remove(removeEl);
                }
            } 
            
        }

        int[] answer = new int[2];
        answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        answer[1] = minHeap.isEmpty() ? 0 : minHeap.poll();
        
        return answer;
    }
}
