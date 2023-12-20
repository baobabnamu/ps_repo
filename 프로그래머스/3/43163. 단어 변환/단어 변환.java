// begin -> target 변환 문제
// 변환 시 words 방문해서 한 글자씩만 변경 가능

class Solution {
    static int answer = 999999;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        // begin에서 방문 가능한 words를 기점으로 탐색
        for(int i=0; i<words.length; i++) {
            // begin과 겹치는 글자가 1개 이하인 경우에만 탐색
            if(compare(begin, words[i]) <= 1) {
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, i, target, words);
            }
        }
        
        // 초깃값과 다른 경우에만 answer 전달
        // 초깃값인 경우 0 전달
        return answer == 999999 ? 0 : answer;
    }
    
    public void dfs(int cnt, int cur, String target, String[] words) {
        // 모든 탐색이 완료된 경우(=target과 동일해진 경우(종료조건))
        if(target.equals(words[cur])) {
            // 경우의 수 비교하여 answer 업데이트
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            // 방문한 적이 없는 문자열 + 현재 비교하고 있는 글자와 겹치는 글자가 1개 이하인 경우에만 dfs 순회
            if(!visited[i] && compare(words[cur], words[i]) <= 1) {
                visited[i] = true;
                dfs(cnt+1, i, target, words);
                // dfs 함수 순회 종료 후 다른 분기 탐색 시 필요하기 때문에 false로 변환
                visited[i] = false;
            }
        }
    }
    
    // 문자열 간 다른 문자가 몇 개인지 비교
    public int compare(String s1, String s2) {
        int n = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) { 
                n++;
            }
        }
        
        return n;
    }
}