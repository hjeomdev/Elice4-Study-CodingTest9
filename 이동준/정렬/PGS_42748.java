import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0]-1,end=commands[i][1],k=commands[i][2];
            ArrayList<Integer> tmp=new ArrayList<>();
            for(int j=start;j<end;j++){
                tmp.add(array[j]);
            }
            tmp.sort(Comparator.naturalOrder());
            answer.add(tmp.get(k-1));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}