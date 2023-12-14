import java.util.*;

class Solution {
    List<String> list;
    String[] words = {"A", "E", "I", "O", "U"};
    
    public void dfs(int depth, String str) {
        list.add(str);
        if(depth == 5) {
            return;
        }
        for(int i=0; i<words.length; i++) {
            dfs(depth + 1, str + words[i]);
        }
    }
    
    public int linearSearch(String word) {
        int cnt = 0;
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                return cnt;            
            }
            cnt++;
        }
        
        return cnt;
    }
    
    public int solution(String word) {
        list = new ArrayList<>();
        dfs(0, "");
        int answer = linearSearch(word);
        return answer;
    }
}