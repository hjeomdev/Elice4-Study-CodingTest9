// 2022. 02. 14
// 소수 찾기
// 미해결: 순열 구하는 방법 이해중...

mport java.util.ArrayList;

class Solution {
    ArrayList<Integer> combinedNum = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 한 글자씩 분리하여 숫자로 바꾸기
        String[] temp = numbers.split("");
        
        int[] slicedNum = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            slicedNum[i] = Integer.parseInt(temp[i]);
        }
        
        // 가능한 모든 순열 만들기
        int n = slicedNum.length;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 1; i <= n; i++) {
            combine(slicedNum, output, visited, 0, n, i);   
        }
        
        // 소수 확인
        for(int i = 0; i < combinedNum.size(); i++) {
            if(isPrime(combinedNum.get(i))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void combine(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            for(int i = 0; i < output.length; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
            int result = 0;
            for(int i = output.length - 1; i >= 0; i--) {
                if(i > 0) {
                    result += output[i] * Math.pow(10, output.length - i);
                } else {
                    result += output[i];
                }
            }
            // System.out.println(result);
            combinedNum.add(result);
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                combine(arr, output, visited, depth + 1, n, r);    
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        // 1은 소수가 아니고, 2와 3은 소수
        if(num == 1) {
            return false;
        } else if(num == 2 || num == 3) {
            return true;
        }
        
        // 1과 자기 자신 외의 수로 나누어 지면 소수가 아님
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}