import java.util.*;

//스택

class Solution {
    public int[] solution(int[] progresses, int[] speeds) { 
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Double> stack1 = new Stack<>();
        Stack<Double> stack2 = new Stack<>();

        for(int i=progresses.length-1; i>-1; i--) {
            double day = Math.ceil((100-progresses[i])/(double)speeds[i]);
            stack1.push(day);
        }
        
        int load = 0;

        while(true) {
            if(stack1.empty()) {
                result.add(load);
                break;
            }
            else if(stack2.empty()) {
                stack2.push(stack1.pop());
                load++;
            }
            else if(stack1.peek() <= stack2.peek()) {
                stack1.pop();
                load++;
            }
            else {
                stack2.push(stack1.pop());
                result.add(load);
                load = 1;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
