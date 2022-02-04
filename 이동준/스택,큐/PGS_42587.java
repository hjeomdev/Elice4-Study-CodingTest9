import java.util.*;

class Pair{
    public int first,second;
    Pair(int x,int y){
        this.first=x; this.second=y;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> q=new LinkedList<>();
        int max=0;
        for(int i=0;i<priorities.length;i++){
            Pair tmp=new Pair(priorities[i],i);
            q.add(tmp);
            if(max<tmp.first){
                max=tmp.first;
            }
        }
        
        ArrayList<Integer>a=new ArrayList(); 
        while(!q.isEmpty()){
            Pair front=q.poll();
            if(max==front.first){
                a.add(front.second);
                //max업데이트
                Object[]tmp=q.toArray();
                max=0;
                for(int i=0;i<tmp.length;i++){
                    Pair here=(Pair)tmp[i];
                    if(max<here.first){
                        max=here.first;
                    }
                }
            }else{
                q.add(front);
            }
        }
        System.out.println(a);
        int answer = a.indexOf(location)+1;
        return answer;
    }
}