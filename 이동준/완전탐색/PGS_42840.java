import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] sp1={1,2,3,4,5};
        int[] sp2={2,1,2,3,2,4,2,5};
        int[] sp3={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int s1=0,s2=0,s3=0;
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==sp1[i%sp1.length])
                s1++;
            if(answers[i]==sp2[i%sp2.length])
                s2++;
            if(answers[i]==sp3[i%sp3.length])
                s3++;
        }
        System.out.println(s1+" "+s2+" "+s3);
        ArrayList<Integer> answer=new ArrayList<>();
        int max=Math.max(s1,s2);
        max=Math.max(max,s3);
        if(max==s1)
            answer.add(1);
        if(max==s2)
            answer.add(2);
        if(max==s3)
            answer.add(3);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}