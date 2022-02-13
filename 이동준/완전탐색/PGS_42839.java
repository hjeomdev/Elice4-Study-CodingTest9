import java.util.*;
class Solution {
    public boolean isPrime(int n){
        //소수인지 판별하는 함수 0,1은 소수가 아니라서 먼저 거름 나머지는 본인보다 작은 숫자로 나눠지는 순간 소수 아님
        if(n==1||n==0)
            return false;
        int i=n-1;
        while(i>1){
            if(n%i==0)
                return false;
            i--;
        }
        return true;
    }
    public HashSet<Integer> result=new HashSet<>();//가능한 모든 순열의 숫자들 저장용, 중복허용 안하려고 해시셋씀
    //https://bcp0109.tistory.com/14?category=848939
    //참고, 스왑으로 안하고 방문처리로 했음
    //https://velog.io/@junhok82/Java%EB%A1%9C-%EC%88%9C%EC%97%B4Permutation-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
    //c++은 라이브러리에 순열 함수가 있는데 자바는 없어서 직접 구현해서 풀어야됨..
    public void per(String numbers, String visited,String now,int n){
        //numbers는 문제의 입력, visited는 기본적으로 입력길이만큼 n개의 0으로 채워짐 방문하면 1 안했으면 0
        //now는 현재 상태의 숫자를 나타내는 문자열, n은 numbers의 길이
        //ex) numbers가 17 visited가 01 이면 now는 7
        if(now.length()==n)
            return;
        for(int i=0;i<n;i++){
            if(visited.charAt(i)=='0'){
                String nowtmp=now+numbers.charAt(i);
                String visitedtmp=visited.substring(0,i)+'1'+visited.substring(i+1);
                result.add(Integer.parseInt(nowtmp));
                per(numbers,visitedtmp,nowtmp,n);
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        int n=numbers.length();
        String tmp="";
        for(int i=0;i<n;i++)
            tmp+="0";
        per(numbers,tmp,"",n);
        System.out.println(result);
        Object[] r=new Object[result.size()];
        result.toArray(r);
        for(int i=0;i<r.length;i++){
            if(isPrime((int)r[i])){
                answer++;
            }
        }
        //처음에는 순열로 생각안하고 조합으로 생각해서 비트마스킹 비스무리하게 풀었었음..
        //문제 풀고나서 다른사람 풀이 봤는데 set을 순회 하는 방법으로 iterator 사용하는 것도 있었음 한번 확인
        //좀 더 찾다가 구글에서 만든 자바 라이브러리에 순열 함수 있는거 발견 
        //https://guava.dev/releases/19.0/api/docs/com/google/common/collect/Collections2.html
        return answer;
    }
}