import java.util.*;

// t초 동안
// 초마다 x만큼 회복
// t초 연속으로 붕대를 가믄데 성공하면 y 회복
// 최대 체력 존재, 공격 받으면 체력 감소, 체력이 0 이하가 되면 캐릭터가 죽음(return -1)
// bandage[기술시전시간][초당회복량][추가회복량] t, x, y
// health = 최대체력
// attacks[몬스터의공격시간][피해량]

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int curHealth = health;
        int time = 0;
        int cnt = 0; // 연속 성공 횟수
        int limitTime = attacks[attacks.length-1][0]; // 최종 공격 횟수
        int attacksIdx = 0;
        
        for(int i=1; i<=limitTime; i++) { // 1~
            if(curHealth <= 0) {
                return -1;
            } else if(curHealth >= maxHealth) {
                curHealth = maxHealth;
            }
            
            // 현재 시간과 공격 시간이 동일한 경우
            if(attacks[attacksIdx][0] == i) {
                cnt = 0;
                curHealth -= attacks[attacksIdx][1];
                attacksIdx++;
            } else { // 동일하지 않은 경우(회복 상태)
                cnt++;
                curHealth += bandage[1];
                if(cnt == bandage[0]) {
                    curHealth += bandage[2];
                    cnt = 0;
                }
            }
            
        }
        
        if(curHealth >= maxHealth) {
            curHealth = maxHealth;
        }
        
        return curHealth <= 0 ? -1 : curHealth;
    }
}