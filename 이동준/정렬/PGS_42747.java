import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        //answer가 항상 citaions 내부에 있는 값이 아닐수도 있다!
        
        //아니 문제를 ㅈ같이 써놨네 10분이면 풀거를 1시간날림
        //"어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고" 
        //요기까지는 이해 쉬운데
        
        //"나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다."
        //처음에는 "나머지 논문이(h번 이상 인용된 논문이 아닌것들) h편 이하로 인용되었다면"로 이해함...
        
        //이말이 h번 이상 인용된 논문의 나머지들의 갯수가 h 이하라는 말인줄 알았는데
        //그게 아니라 그냥 ㄹㅇ 나머지것들이 h번 이하로 인용됬다는 당연한 말이었네
        
        int answer = 0;
        for(int h=citations.length;h>=0;h--){
            int cnt=0; //h이상 인용된 논문 수
            for(int i=0;i<citations.length;i++){
                if(h<=citations[i]){
                    //cnt++;
                    cnt=citations.length-i; //소팅한거 써먹어야지.. 근데 시간 얼마 차이 안남 한 0.7ms?
                    break;
                }
            }
            if(h<=cnt){//&&citations.length-cnt<=h){ //ㅅㅂ..
                answer=h;
                break;
            }            
        }
        return answer;
    }
}