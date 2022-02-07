import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer>minheap=new PriorityQueue<>();
        PriorityQueue<Integer>maxheap=new PriorityQueue<>(Collections.reverseOrder());
        int size=0;
        HashMap<Integer,Integer> a=new HashMap();//원소, 갯수
        
        for(int i=0;i<operations.length;i++){
            if(operations[i].charAt(0)=='I'){ //원소 삽입
                int tmp=Integer.parseInt(operations[i].substring(2,operations[i].length()));
                minheap.add(tmp);
                maxheap.add(tmp);
                if(a.get(tmp)==null){
                    a.put(tmp,1); 
                }else{
                    a.put(tmp,a.get(tmp)+1); 
                }
                size++;
            }else{
                if(size!=0){
                    if(operations[i].charAt(2)=='-'){//최소값 삭제
                        while(a.get(minheap.peek())==0){
                            minheap.poll();
                        }
                        int tmp=minheap.poll();
                        a.put(tmp,a.get(tmp)-1);
                    }else{//최대값 삭제
                        while(a.get(maxheap.peek())==0){
                            maxheap.poll();
                        }
                        int tmp=maxheap.poll();
                        a.put(tmp,a.get(tmp)-1);
                    }
                    size--;
                }
            }
        }
        
        //하기전에 minheap maxheap 원소 갯수 맞춰주기
        //int[] answer = {maxheap.peek(),minheap.peek()};
        // System.out.println(a);
        // System.out.println(maxheap);
        // System.out.println(minheap);
        int[] answer={0,0};
        if(size!=0){
            while(a.get(minheap.peek())==0){
                minheap.poll();
            }
            while(a.get(maxheap.peek())==0){
                maxheap.poll();
            }
            answer[0]=maxheap.peek();
            answer[1]=minheap.peek();
        }
        return answer;
    }
}