import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String p : participant) {
            if(map.containsKey(p)) {
                map.put(p, (map.get(p)) + 1);
            } else {
                map.put(p, 1);
            }
        }
        
        for(String c : completion) {
            map.put(c, (map.get(c)) - 1);
        }
        
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}