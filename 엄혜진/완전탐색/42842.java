// 2022. 02. 14
// 카펫

import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
//         // 1안. 두 수의 합의 약수 구하기 => 주어진 yellow 수가 적으면 조건을 만족하지 못한다.
//         int num = brown + yellow;
//         ArrayList<Integer> divisor = new ArrayList<>();
        
//         for(int i = 1; i <= num; i++) {
//             if(num % i == 0) {
//                 divisor.add(i);
//             }
//         }
        // 큰 값을 첫번째로 넣어서 가로, 세로 순으로 만들기
//         int widthIdx, heightIdx;
//         if(divisor.size() % 2 == 0) {
//             widthIdx = divisor.size() / 2;
//             heightIdx = widthIdx - 1;
//         } else {
//             widthIdx = divisor.size() / 2;
//             heightIdx = widthIdx;
//         }
        
//         answer[0] = divisor.get(widthIdx);
//         answer[1] = divisor.get(heightIdx);
        
        
        // 2안. 상대적으로 작은 yellow의 약수를 구하고, 그 수와 조건이 맞는 brown의 약수를 구한다
        ArrayList<Integer> yellowDivisor = new ArrayList<>();
        
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i == 0) {
                yellowDivisor.add(i);
            }
        }
        
        int width = 0, height = 0;
        if(yellowDivisor.size() % 2 == 0) {
            for(int i = 0; i < yellowDivisor.size() / 2; i++) {
                height = yellowDivisor.get(i);
                width = yellowDivisor.get(yellowDivisor.size() - i - 1);
                if((height * 2 + 2) + (width * 2 + 2) == brown) {
                    break;
                }
            }
        } else {
            for(int i = 0; i <= yellowDivisor.size() / 2; i++) {
                height = yellowDivisor.get(i);
                width = yellowDivisor.get(i);
                if((height * 2 + 2) + (width * 2 + 2) == brown) {
                    break;
                }
            }
        }
        
        
        
        // 큰 값을 첫번째로 넣어서 가로, 세로 순으로 만들기
        answer[0] = width + 2;
        answer[1] = height + 2;
        
        return answer;
    }
}