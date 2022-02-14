import java.util.*;

//해시

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int nameIdx = 0;
        int kindIdx = 1;
        
        for(int i=0; i<clothes.length; i++) {
            String clotheKind = clothes[i][kindIdx];
            
            if(map.containsKey(clotheKind)) {
                int count = map.get(clotheKind);
                count++;
                map.replace(clotheKind, count);
            }
            
            map.putIfAbsent(clotheKind, 1);
            
        }
        
        ArrayList<String> kindList = new ArrayList<>(map.keySet());
        
        if(map.size() == 1) {
            return map.get(kindList.get(0));
        }
        else {
            int tempMul = 1;
            int result = 0;
            
            for(String kind: kindList) {
                tempMul *= map.get(kind)+1;
                result = tempMul-1;
            }
            return result;
        }
        
    }
}
