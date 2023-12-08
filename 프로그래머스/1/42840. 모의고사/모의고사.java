import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
//         가장 문제 많이 맞춘 사람
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == first[i%5]) score[0]++;
            if(answers[i] == second[i%8]) score[1]++;
            if(answers[i] == third[i%10]) score[2]++;
        }
        
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        ArrayList<Integer> intAL = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) if(score[i]==max) intAL.add(i+1);
        
        return intAL.stream().mapToInt(x->x).toArray();
    }
}