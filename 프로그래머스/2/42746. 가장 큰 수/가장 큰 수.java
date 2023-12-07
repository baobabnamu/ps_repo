import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) 
            arr[i] = String.valueOf(numbers[i]);

        // 배열 정렬
        // 일반적인 내림차순 정렬 시 반례 발생. 반례 예시) 3, 30, 34 -> 34303으로 정렬됨. 
        // sort의 인자로 Comparator를 전달 및 문자열 조합 후 비교한뒤 더 큰 값이 먼저 위치하도록 구현(내림차순)
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 배열에 0만 담겨있는 경우
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) 
            sb.append(arr[i]);
        
        return sb.toString();
    }
}