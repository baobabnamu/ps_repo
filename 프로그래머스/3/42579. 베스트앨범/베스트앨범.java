import java.util.*;
 
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
 
        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        
        for(int i = 0; i < plays.length; i++) { // 이중 해싱 데이터 넣기
            if(!num.containsKey(genres[i])) { // 장르 배열 순회하다가 처음 보는 장르라면
                HashMap<Integer, Integer> map = new HashMap<>(); // 노래의 고유번호, 재생횟수를 저장할 임시 map
                map.put(i, plays[i]); 
                music.put(genres[i], map); 
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]); // 이중해싱 HashMap 활용해 장르에 속하는 노래 및 재생횟수 추가
                num.put(genres[i], num.get(genres[i]) + plays[i]); // 장르별 총 개수 누적
            }
        }
 
        List<String> keySet = new ArrayList(num.keySet()); // 장르별 누적횟수 비교를 위해 장르 List 생성
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1))); // 장르별 누적횟수 정렬
 
        for(String key : keySet) { // 장르에 속하는 노래 및 재생횟수 정렬을 위해 정렬된 장르 List 순회
            HashMap<Integer, Integer> map = music.get(key); // 장르 Key를 통해 장르에 속하는 노래와 노래의 재생 횟수 가져오기
            List<Integer> song_id = new ArrayList(map.keySet()); // 노래 고유번호 키셋 추출
 
            Collections.sort(song_id, (s1, s2) -> map.get(s2) - (map.get(s1))); // 노래의 재생횟수 정렬
 
            answer.add(song_id.get(0)); // 장르의 재생횟수 중 가장 큰 값 answer 리스트에 추가
            if(song_id.size() > 1) // 장르의 재생횟수 중 두 번째로 큰 값이 존재하는 경우
                answer.add(song_id.get(1));  // 두 번째 값만 answer 리스트에 추가
        }
 
        return answer.stream().mapToInt(i -> i).toArray(); // List -> array 형태로 변환
    }
}