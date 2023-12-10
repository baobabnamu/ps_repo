import java.util.*;

class Solution {
//     set 자료구조 생성
    HashSet<Integer> numbersSet = new HashSet<>();

//     순열 재귀 함수
    public void recursive(String comb, String others) {
        if(!comb.equals("")) 
            numbersSet.add(Integer.valueOf(comb));
        
        // 아이디어 : 하나의 조합을 만든 후 다음 전달되는 문자열에서 한 개를 제거
        // 예) 처음에 "", 127를 호출했으면 "1" 이라는 조합을 만들고 "27"를 매개변수로 전달함.
        // recursive("", 127) -> recursive("1", 27) ... 순으로 실행됨.
        // 만약 for문의 i가 증가하면 시작점이 변경되므로 recursive("2", 17) -> recursive("21", 7) ... 순으로 실행됨.
        for(int i=0; i<others.length(); i++) 
            recursive(comb+others.charAt(i), others.substring(0, i)+others.substring(i+1));
    }
    
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        
        int lim = (int)Math.sqrt(num);
        
        for(int i=2; i<=lim; i++)
            if(num%i == 0) return false;
        
        return true;
    }
    
    public int solution(String numbers) {
        recursive("", numbers);
        
        int answer = 0;
        
        Iterator<Integer> it = numbersSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
}