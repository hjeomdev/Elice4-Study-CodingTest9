import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = citations.length - 1; i >= 0; i--) {
            int remain = citations.length - i;
            
			if (citations[i] <= remain) {
                
                answer = citations[i] == remain ? citations[i] : remain - 1;
				break;
            }
        }
        
        return answer;
    }
}