import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] done = {}; // 작업별 완료까지 날짜
        
        // queue(타입을 배열로 하여 진도, 속도 같이 저장, 링크만 변경)
        List<int[]> queue = new LinkedList<>();
        
        // 큐에 진도와 속도, 완료까지 날짜 계산한 값 추가
        for(int i = 0; i < speeds.length; i++) {
            queue.add(new int[]{ progresses[i], speeds[i] });
        }
        
        // 결과값을 저장할 리스트
        List<Integer> result = new ArrayList<>();
        
        while(queue.size() > 0) {
            
            // 전체적으로 진도에 하루치 속도를 더함
            for(int[] arr : queue) {
                arr[0] += arr[1];
            }
            
            // 0번 작업이 100이 되면
            if(queue.get(0)[0] >= 100) {
                int cnt = 0;
                
                // 맨앞부터 추출 작업
                for(int i = 0; i < queue.size();){
                    // 100이 넘는 작업을 찾아 추출, 개수를 세어줌
                    if(queue.get(i)[0] >= 100) {
                        queue.remove(i);
                        cnt++;
                    } else {
                        break;
                    }
                }
                // 추출이 끝나고 cnt값을 추가
                result.add(cnt);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
