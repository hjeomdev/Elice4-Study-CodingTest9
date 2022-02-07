import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int k = 0; k < commands.length; k++) {
            int[] temp = new int[commands[k][1] - commands[k][0] + 1]; // i부터 j까지 숫자들 임시 저장
            int p = 0;
            
            for(int m = commands[k][0]-1; m < commands[k][1]; m++) {
                temp[p++] = array[m];
                
            }
            
            Arrays.sort(temp);
            answer[k] = temp[commands[k][2]-1];
        }
        
        return answer;
    }
}