import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(); //그냥 하면 최소힙
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek()<K){
            int m1=pq.poll();
            int m2=pq.poll();
            pq.add(m1+m2*2);
            answer++;
            if(pq.size()==1&&pq.peek()<K){
                answer=-1; break;
            }
        }
        return answer;
    }
}