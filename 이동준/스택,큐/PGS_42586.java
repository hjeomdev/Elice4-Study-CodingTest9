import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> day=new ArrayList();
        for(int i=0;i<progresses.length;i++){
            day.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
        //System.out.println(day);
        ArrayList<Integer>answer = new ArrayList();
        int today=1;
        for(int i=0;i<progresses.length;i++){
            if(today<day.get(i)){
                today=day.get(i);
                answer.add(1);
            }else{
                answer.set(answer.size()-1,answer.get(answer.size()-1)+1);
            }    
            //System.out.println(answer);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}