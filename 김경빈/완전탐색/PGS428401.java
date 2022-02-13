import java.util.ArrayList;
import java.util.List;

public class PGS42840 {

    public static List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] scores = { 0, 0, 0 };
        int[][] patterns = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };

        for (int i = 0; i < answers.length; i++) {
            if (patterns[0][i % 5] == answers[i])
                scores[0]++;
            if (patterns[1][i % 8] == answers[i])
                scores[1]++;
            if (patterns[2][i % 10] == answers[i])
                scores[2]++;

        }

        int max = Math.max(Math.max(scores[0], scores[1]), scores[2]);

        for (int j = 0; j < scores.length; j++) {
            if (scores[j] == max)
                answer.add(j + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answers1 = { 1, 2, 3, 4, 5 };
        int[] answers2 = { 1, 3, 2, 4, 2 };
        int[] answers3 = { 1, 3, 2, 4, 2, 4, 2, 5, 2, 1, 3, 4, 5, 3, 2, 1, 4 };
        int[] answers4 = { 2, 1, 4 };

        System.out.println(solution(answers1));
        System.out.println(solution(answers2));
        System.out.println(solution(answers3));
        System.out.println(solution(answers4));
    }
}
