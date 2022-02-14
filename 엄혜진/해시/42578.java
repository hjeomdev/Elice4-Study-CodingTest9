// 2022. 02. 06
// 위장

import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            hashmap.put(clothes[i][1], 1 + hashmap.getOrDefault(clothes[i][1], 0));
        }
        
        Iterator<String> iter = hashmap.keySet().iterator();
        while(iter.hasNext()) {
            answer *= hashmap.get(iter.next()) + 1; // 조합 이용
        }
        
        return answer - 1;
    }
}