// 2022. 02. 20
// 체육복
// 미해결: 런타임에러

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] cloth = new int[n];
        
        // 가지고 있는 체육복 총 개수 확인
        for(int i = 0; i < n; i++) {
            cloth[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++) {
            cloth[lost[i] - 1] -= 1;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            cloth[reserve[i] - 1] += 1;
        }
    
        // 옷을 0개 가지고 있으면 앞, 뒤 사람을 확인해서 1로 만들기
        // 다음 사람으로 넘어가기 전에, 앞 사람이 1개 이상의 옷을 가지고 있는지 확인
        for(int i = 0; i < n; i++) {
            if(cloth[i] == 0) {
                // 앞 확인
                if(i > 0 && cloth[i - 1] > 1) {
                    cloth[i - 1] -= 1;
                    cloth[i] += 1;
                }
                // 뒤 확인
                else if(i < n && cloth[i + 1] > 1) {
                    cloth[i + 1] -= 1;
                    cloth[i] += 1;
                }
            }
            
            if(i >= 1 && cloth[i - 1] < 1) {
                answer--;
            }
        }
        
        if(cloth[n - 1] < 1) {
                answer--;
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(cloth[i]);
        }
        System.out.println(answer);
        
        return answer;
    }
}