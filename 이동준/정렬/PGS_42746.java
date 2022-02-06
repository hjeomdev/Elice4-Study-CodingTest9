import java.util.*;
        /*
        처음엔 comparator를 직접 스트링 하나하나 비교하며 만들었는데 너무 복잡해져서
        만약에 6,10,2 면 6666,1011,2222로 변환해서 정렬하고 다시 합치는 방법으로 했는데 이러면 
        67 676
        979 97
        같은 경우 처리하기 까다로워서
        그냥 comparator 내부에서 직접 int두개를 순서 바꿔서 2개의 string으로 만들고 비교하는 식으로함
        */
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String>nts=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            nts.add(Integer.toString(numbers[i]));
        }
        nts.sort((s1,s2)->{
            //직접 합쳐보고 큰쪽으로 정렬
            int i1=Integer.parseInt(s1+s2);
            int i2=Integer.parseInt(s2+s1);
            return i2-i1;
        });        
        String answer = "";
        for(String s : nts){
            answer+=s;
        }
        
        //[0, 0, 0, 0, 0] 인경우 "0"이 되도록 함 이거 안하면 "00000"이렇게됨
        boolean b=true;
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)!='0'){
                b=false;
                break;
            }
        }
        if(b){
            answer="0";
        }
        return answer;
    }
}