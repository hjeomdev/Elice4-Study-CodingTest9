import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        //일단 소인수분해하고 가능한 조합 다 보면서 brown 기준 되는지 확인
        //가로가 더 길다!!  문제 조건 확인

        ArrayList<Integer> sss=new ArrayList<>();   //소인수분해한 결과가 들어감 48의 경우 2 3 4 6 까지 들어감 
        for(int i=2;i<=Math.sqrt(brown+yellow);i++){
            if((brown+yellow)%i==0){
                sss.add(i);
            }
        }
        //System.out.println(sss);
        int garo=1,sero=1;
        for(int i=sss.size()-1;i>=0;i--){
            sero=sss.get(i); garo=(brown+yellow)/sero;
            
            if((garo-2)*2+(sero-2)*2+4==brown)
                break;
        }
        
        /*처음 푼 방식. 요따구로 풀면 중간에 빠지는게 생김.. 소인수 분해 방법을 저렇게 하지 말고 다르게 합시다..
        이렇게 하면 60의 경우 소인수 분해가 2 2 3 5로 되고 
        
        2 30
        4 15
        12 5
        만 되고 그 다음 반복문에서 3 20같은 경우가 빠짐

        long area=brown+yellow;
        ArrayList<Integer> ss=new ArrayList<>();
        int k=2;
        while(area!=1){
            if(area%k==0){
                ss.add(k);
                area/=k;
            }else
                k++;
        }
        
        for(int i=ss.size()-1;i>0;i--){
            garo=1;sero=1;
            for(int j=0;j<i;j++)
                garo*=ss.get(j);
            for(int j=i;j<ss.size();j++)
                sero*=ss.get(j);
            if(sero>garo){
                int tmp=sero;
                sero=garo;
                garo=tmp;
            }
            //System.out.println(garo+" "+sero);
            // if((garo-2)*2+(sero-2)*2+4==brown)
            //     break;
            if((garo-2)*(sero-2)==yellow&&(garo-2)*2+(sero-2)*2+4==brown)
                break;
        }*/
        
        // //또다른 정답 완전 ㄹㅇ 무식한 완탐 차라리 이게 코드도 간단하긴함.. 다른사람 풀이 보고 따라쓴거
        // //그냥 가로 길이를 2부터 문제 범위로 대충 가능한 수까지 일일히 다 계산 해보는것.
        // //심지어 이게 실행시간 절반정도 짧음..
        // for(int i=1;i<5001;i++){
        //     if((brown+yellow)%i==0){
        //         int j=(brown+yellow)/i;
        //         int tmpi=i;
        //         if(j>i){
        //             int tmp=i;
        //             tmpi=j;
        //             j=tmp;
        //         }
        //         if((i-2)*(j-2)==yellow&&(i-2)*2+(j-2)*2+4==brown){
        //             int[] answer = {i,j};
        //             return answer;    
        //         }    
        //     }
        // }
        
        int[] answer = {garo,sero};
        return answer;
        
    }
}