// 2022. 02. 06
// 전화번호 목록
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Boolean> pf = new HashMap<>();

        // 정확성 테스트는 통과했는데 효율성 테스트는 통과하지 못했다..
        // for(int i = 0; i < phone_book.length; i++) {
        //     pf.put(phone_book[i], true);
        //     int i_len = phone_book[i].length();
        //     for(int j = 0; j < phone_book.length; j++) {
        //         if(i != j && phone_book[j].length() >= i_len) {
        //             String j_prefix = phone_book[j].substring(0, i_len);
        //             if(pf.containsKey(j_prefix)) {
        //                 System.out.println(j_prefix);
        //                 return false;
        //             }
        //         }
        //     }
        // }

        // 1시간 반째 도전하다가 구글링했다... 나는 왜 문제를 어렵게 풀지...
        for(int i = 0; i < phone_book.length; i++) {
            pf.put(phone_book[i], i);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(pf.containsKey(phone_book[i].substring(0, j))) { // 번호의 부분이 prefix가 될 수 있다는 것을 놓쳤다.
                    return false;
                }
            }
        }
        
        return answer;
    }
}