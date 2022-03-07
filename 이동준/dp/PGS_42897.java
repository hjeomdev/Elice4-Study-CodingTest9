import java.util.*;
class Solution {
    //시간초과랑 메모리초과남
    public int chk(int[] visited,int[] money){
        int total=0;
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0)
                return -1;
            if(visited[i]==1)
                total+=money[i];
        }
        return total;
    }
    public int dp(int[] visited,int here,int [] money){
        if(chk(visited,money)!=-1){
            return chk(visited,money);
        }
        int len=visited.length;
        int[] herePick=new int[visited.length];
        int[] dontPick=new int[visited.length];
        for(int i=0;i<len;i++){ //복사
            herePick[i]=visited[i]; dontPick[i]=visited[i];
        }
        int b=(here-1+len)%len,f=(here+1)%len; //here의 앞뒤 인덱스
        if(visited[b]==1||visited[f]==1){//앞또는 뒤를 턴 경우 현재 위치는 못털음
            herePick[here]=-1;
        }else{
            herePick[here]=1;
        }
        dontPick[here]=-1;
        int pick=dp(herePick,(here+1)%len,money);//money 계산값
        int dontpick=dp(dontPick,(here+1)%len,money);
        return Math.max(pick,dontpick);
    }
    
    public int solution(int[] money) {
        int[] now=new int[money.length]; //현재 상태 뽑았으면 1 안뽑을 거면 -1 아직 방문 안한거면 0
        int answer = dp(now,0,money);
        return answer;
    }
}