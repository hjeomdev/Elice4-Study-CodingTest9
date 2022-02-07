import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        List<int[]> truck = new LinkedList<>(); // 다리를 건너는 트럭, [무게, 시간]
        
        int answer = 0;
        int totalWeight = 0;
        int i = 0;
        
        
        while(true) {
            
            // 다리 위에 트럭이 있을 때 시간 1 감소
            for(int j = 0; j < truck.size();) {
                
                if(--truck.get(j)[1] == 0) {
                    totalWeight -= truck.get(j)[0];
                    truck.remove(j);
                } else {
                    j++;
                }
            }
            
            // 다음 트럭의 무게 + 다리 위 트럭의 무게 합 < weight -> 다리 위에 추가
            if (i < truck_weights.length && truck_weights[i] + totalWeight <= weight) {
				totalWeight += truck_weights[i];
				truck.add(new int[] { truck_weights[i++], bridge_length });
			}
            
            answer += 1;
            
            if(truck.size() == 0) {
                break;
            }
        }
        
        return answer;
    }
}