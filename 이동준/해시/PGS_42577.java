import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 자바 해시에서 containsKey함수는 O(1)이네?? armotize하게 분석해서 그런듯
        //O(n*m) 전화번호갯수*길이
        // HashMap<String, Integer> h = new HashMap<>();
        // for(int i=0;i<phone_book.length;i++)
        //     h.put(phone_book[i],i);
        // for(int i=0;i<phone_book.length;i++){
        //     for(int j=0;j<phone_book[i].length();j++){
        //         if(h.containsKey(phone_book[i].substring(0,j)))
        //             return false;
        //     }
        // }
        
        //전체를 정렬해서(사전순으로) 앞뒤로 인접한 스트링끼리만 비교해도 가능
        //O(nlgn+n) 효율성 테스트하면 이게 더 빠르긴함
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        
        /*
        //O(n^2)
        for(int i=0;i<phone_book.length-1;i++){
            String prefix=phone_book[i];
            for(int j=i+1;j<phone_book.length;j++){
                String search=phone_book[j];
                // search 하나씩 돌면서 비교
                // int len=Math.min(prefix.length(),search.length());
                // boolean same=true;
                // for(int k=0;k<len;k++){
                //     if(prefix.charAt(k)!=search.charAt(k)){
                //         same=false;
                //         break;
                //     }
                // }
                // if(same){
                //     return false;
                // }
                
                //String에 startsWith() 
                if(search.length()<prefix.length()){
                    if(prefix.startsWith(search)){
                        return false;
                    }
                }else{
                    if(search.startsWith(prefix)){
                        return false;
                    }
                }
            }
        }*/
        return true;
    }
}