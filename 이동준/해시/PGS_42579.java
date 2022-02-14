import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        HashMap<String,Integer> h = new HashMap<>();
        HashMap<String,ArrayList<Integer>> g= new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            if(h.get(genres[i])==null){
                h.put(genres[i],plays[i]);
                ArrayList<Integer> a=new ArrayList();
                a.add(i);
                g.put(genres[i],a);
            }else{
                h.put(genres[i],h.get(genres[i])+plays[i]);
                ArrayList<Integer>a=g.get(genres[i]);
                a.add(i);
                g.put(genres[i],a);
            }
        }
        
        List<Map.Entry<String,Integer>>el=new ArrayList<>(h.entrySet());
        el.sort(((o1, o2) -> o2.getValue() - o1.getValue())); //내림차순
        
        ArrayList<Integer> answer=new ArrayList();
        
        for(Map.Entry<String,Integer>e:el){
            //System.out.println(e.getKey()+" "+e.getValue());
            List<Integer>l=new ArrayList<>(g.get(e.getKey()));
            if(l.size()==1){
                answer.add(l.get(0));
            }else{
                l.sort(((o1, o2) -> plays[o2]-plays[o1])); //내림차순
                answer.add(l.get(0));
                answer.add(l.get(1));
            }
        }
        
        // for(Map.Entry<String,ArrayList<Integer>>e:g.entrySet()){
        //     System.out.println(e.getKey()+" "+e.getValue());
        // }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}