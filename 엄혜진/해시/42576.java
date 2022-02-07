// 2022. 02. 06
// 완주하지 못한 선수

import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> marathonList = new HashMap<>();

        // 참여한 선수 -> + 1
        for(int i = 0; i < participant.length; i++) {
            String ptcp = participant[i];
            marathonList.put(ptcp, 1 + marathonList.getOrDefault(ptcp, 0));
        }
        
        // 완주한 선수 -> - 1
        for(int i = 0; i < completion.length; i++) {
            String cplt = completion[i];
           if(marathonList.containsKey(cplt)) {
               marathonList.replace(cplt, marathonList.get(cplt) - 1); 
           } 
        }
        
        Iterator<String> iter = marathonList.keySet().iterator();
        while(iter.hasNext()) {
            String temp = iter.next();
            if(marathonList.get(temp) > 0) { // 완주한 경우 -> 0
                answer += temp;
            }
        }
        
        return answer;
    }
}