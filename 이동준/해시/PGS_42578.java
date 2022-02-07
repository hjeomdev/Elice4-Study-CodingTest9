import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer>h=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(h.get(clothes[i][1])==null){
                h.put(clothes[i][1],1);
            }else{
                h.put(clothes[i][1],h.get(clothes[i][1])+1);
            }
        }
        
        /*
        4종류 a,b,c,d개라면
        4c1 : a+b+c+d
        4c2 : ab+ac+ad+bc+bd+cd
        4c3 : abc+abd+acd+bcd
        4c4 : abcd
        결국 (a+1)(b+1)(c+1)(d+1)-1 과 같다..
        */
        Object[] c=h.values().toArray();
        for(int i=0;i<c.length;i++){
            answer*=(int)c[i]+1;
        }
        answer-=1;
        
        
        /*
        //비트로 바꿔서 했는데 시간초과뜸;;        
        int size=(int)Math.pow(2,c.length);
        for(int i=1;i<size;i++){
            String here=String.format("%"+c.length+"s",Integer.toBinaryString(i)).replace(' ','0');
            // System.out.println(here);
            int tmp=1;
            for(int j=0;j<here.length();j++){
                if(here.charAt(j)=='1'){
                    tmp*=(int)c[j];
                }
            }
            answer+=tmp;
            // System.out.println(answer);
        }
        
        /*
        4종류 a,b,c,d개
        4c1 : a+b+c+d   0001 0010 0100 1000
        4c2 : ab+ac+ad+bc+bd+cd 0011 0110 1100 1010 0101 1001
        4c3 : abc+abd+acd+bcd 1110 1101 1011 0111
        4c4 : abcd 1111
        
        1~15
        
        1~7
        001 010 011 100 101 110 111
        
        1~3
        01 10 11
        
        1
        1
        
        */
        
        return answer;
    }
}