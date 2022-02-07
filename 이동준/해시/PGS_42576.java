import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap <String, Integer> p=new HashMap<>();
        for(int i=0;i<participant.length;i++){
            p.put(participant[i],p.containsKey(participant[i])?p.get(participant[i])+1:1);
        }
        for(int i=0;i<completion.length;i++){
            p.put(completion[i],p.get(completion[i])-1);
        }
        for(Map.Entry<String, Integer>e:p.entrySet()){
            if(e.getValue()!=0)
                answer=e.getKey();
        }
        
        return answer;
    }
}