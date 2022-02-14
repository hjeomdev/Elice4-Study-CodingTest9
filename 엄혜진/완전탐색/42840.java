// 2022. 02. 14
// 모의고사
// 미해결: 런타임 에러

import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        // 수포자의 문제 찍는 방식
        int[][] spj = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 맞힌 문제 개수 카운트
        int[] correctCount = {0, 0, 0};
        
        int index0 = 0, index1 = 0, index2 = 0;
        for(int i = 0; i < answers.length; i++) {
            // 1번
            if(answers[i] == spj[0][index0]) {
                correctCount[0] += 1;
            }
            if(index0 > spj[0].length - 1) {
                index0 = 0;
            } else {
                index0++;   
            }
            // 2번
            if(answers[i] == spj[1][index1]) {
                correctCount[1] += 1;
            }
            if(index1 > spj[1].length - 1) {
                index1 = 0;
            } else {
                index1++;    
            }
            // 3번
            if(answers[i] == spj[2][index2]) {
                correctCount[2] += 1;
            }
            if(index2 > spj[2].length - 1) {
                index2 = 0;
            } else {
                index2++;
            }
        }
        
        // 가장 많이 맞힌 사람
        
//         Arrays.sort(correctCount);
//         int[] index = {correctCount.length-1};
//         int max = correctCount[correctCount.length-1];
//         for(int i = correctCount.length - 2; i > 0; i--) {
//             if(max < correctCount[i]) {
                
//             }
//         }
        
        int max = 0;
        int answerIdx = 0;
        for(int i = 0; i < 3; i++) {
            if(max < correctCount[i]) {
                max = correctCount[i];
                answer = new int[3];
                answerIdx = 0;
                answer[answerIdx++] = i + 1;
            } else if(max == correctCount[i]) {
                answer[answerIdx++] = i + 1;
            }
        }
        
        if(answerIdx <= 3) {
            answer = Arrays.copyOfRange(answer, 0, answerIdx);
        }
        return answer;
    }
}