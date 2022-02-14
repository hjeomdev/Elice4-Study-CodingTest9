import java.util.*;

//큐

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.offer(i);
            map.put(i,priorities[i]);
        }
        
        while(true) {
            if(!map.containsKey(location)) {
                break;
            }
            
            int num = queue.peek();
            if(map.get(num) >= max(map.values())) {
                queue.poll();
                map.remove(num);
                answer++;
            } else {
                queue.offer(queue.poll());
            }
        }
        
        return answer;
    }
    
    public int max(Collection<Integer> array) {
        int max = 0;
        for(int i: array) {
            if(max <= i) {
                max = i;
            } else {
                continue;
            }
        }
        return max;
    }
}
