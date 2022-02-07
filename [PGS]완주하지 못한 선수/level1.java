import java.util.HashMap;

//해시

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String s: participant) {
            if(map.containsKey(s)) {
                int count = map.get(s);
                count++;
                map.replace(s, count);
            };
            map.putIfAbsent(s, 1);
        }
        
        for(String s: completion) {
            int value = map.get(s);
            value--;
            map.replace(s, value);
        }
        for(String s: map.keySet()) {
            if(map.get(s) != 0) {answer = s;}
        }
        return answer;
    }
}