import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int pass_truck=0; //다리 지나간 트럭 수
        int now=0; //현재 다리에 올라온 트럭의 총 무게
        int front_truck=0; //대기 트럭중 가장 앞에 있는 놈
        Queue <Integer>q=new LinkedList<>(); //다리 상태 항상 다리 길이만큼 원소가 있음. 빈칸은 0, 트럭은 무게로 입력
        for(int i=0;i<bridge_length;i++)
            q.add(0);
        
        while(pass_truck<truck_weights.length){
            answer++;
            int tmp=q.poll();
            if(tmp!=0){
                pass_truck++;
                now-=tmp;
            }
            if(front_truck<truck_weights.length){
                if(now+truck_weights[front_truck]<=weight){//다리에 트럭 올림
                    q.add(truck_weights[front_truck]);
                    now+=truck_weights[front_truck];
                    front_truck++;
                }else{//못올림
                    q.add(0);
                }
            }
            //System.out.println(q);
        }
        /* 큐 내부는 항상 다리 길이만큼 원소가 있음 (빈칸은 0, 트럭은 무게로 입력)
            00
            07
            70
        7   04
        7   45
        74  50
        745 06
        745 60
        7456
        */
        
        return answer;
    }
}