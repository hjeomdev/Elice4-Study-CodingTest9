import java.util.*;

class Pair{
    public int first,second;
    Pair(int x,int y){
        this.first=x; this.second=y;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        /*
        해당 시점에서 가장 수행 시간이 짧은 것을 우선으로 실행하면 전체 수행시간이 준다. -> 평균 시간도 준다
        뭔가 논리적으로 증명하는 방법은 안떠오르는데
        직관적으로 모든 작업이 동시에 들어왔다고 했을때 가장 긴거부터 실행하면 나머지가 그만큼 기다리지만
        짧은거 부터 하면 그만큼 짧게 기다린다고 볼수 있으니깐
        지금은 힙문제로 알고 봐서 이렇게 생각했지만 만약에 아무런 힌트없이 봤을때도 똑같이 생각할수 있으려나 모르겠따.
        
        [[24, 10], [28, 39], [43, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]] = 72
        [[0, 5], [2, 10], [10000, 2]] = 6
        엣지케이스 참고용
        
        큐를 두개 만들어야됨.. 입력이 정렬이 안되있을수도 있어서 먼저 정렬용 큐, 실행용 큐
        처음에 이생각을 못했음.. 그냥 실행큐 하나로 만들었는데 계속 틀려서 왜그런가 했더니
        입력이 정렬이 되있다고 문제에 안써있었음
        */
        PriorityQueue<Pair>pq1=new PriorityQueue<>( //입력 정렬용 큐
            (o1,o2)->{
                if(o1.first==o2.first){//같은 시점에 입력된경우 실행시간 적은놈이 우선
                    return o1.second-o2.second;
                }
                return o1.first-o2.first;
            });
        int answer = 0; //총 소요시간
        int now=0; //현재시간
        int remainTime=0; //작업 끝날때까지 남은 시간
        
        PriorityQueue<Pair>pq2=new PriorityQueue<>( //실행용 큐
            (o1,o2)->{
                return o1.second-o2.second;//실행시간 적은놈이 우선
            });
        
        for(int i=0;i<jobs.length;i++){
            Pair tmp=new Pair(jobs[i][0],jobs[i][1]);
            pq1.add(tmp);
        }
        
        while(!(pq2.isEmpty()&&pq1.isEmpty())){
            //목록큐에서 실행큐로이동
            //같은 시간에 여러개 들어올 수도 있으니까
            while(!pq1.isEmpty()&&pq1.peek().first==now){ //목록에 있는 작업 요청시간이 지금이라면 큐에 추가
                Pair tmp=pq1.poll();
                pq2.add(tmp);
            }
            
            if(remainTime<=0){//작업중이지 않으면 실행큐에서 뽑음
                Pair min=pq2.poll();
                if(min!=null){
                    answer+=(now-min.first)+min.second;
                    remainTime=min.second;
                }
            }
            //System.out.println(now+" "+remainTime+" "+answer);
            remainTime--;
            now++;
        }
        return answer/jobs.length;
    }
}