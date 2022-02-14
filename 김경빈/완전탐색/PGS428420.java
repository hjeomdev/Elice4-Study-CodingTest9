import java.util.Arrays;

public class PGS42842 {
  public static int[] solution(int brown, int yellow) {
    int[] yellowEdge = findYellowEdge(brown, yellow);

    // 변마다 각 추가
    int[] answer = { yellowEdge[0] + 2, yellowEdge[1] + 2 };

    return answer;
  }

  // 노란색의 가로, 세로
  public static int[] findYellowEdge(int brown, int yellow) {
    int[] result = new int[2]; // [width, height]
    int target = brown / 2 - 2;
    int yellowWidth = 1;

    // yellowWidth + yellowHeight = brown/2 - 2
    // (yellowWidth * yellowHeight) = yellow
    while (true) {

      if (yellowWidth + (yellow / yellowWidth) == target && yellowWidth >= (yellow / yellowWidth)) {
        result[0] = yellowWidth;
        break;
      } else {
        yellowWidth += 1;
      }
    }
    result[1] = yellow / yellowWidth;

    return result;
  }

  public static void main(String args[]) {
    System.out.println(Arrays.toString(solution(10, 2)));
    System.out.println(Arrays.toString(solution(8, 1)));
    System.out.println(Arrays.toString(solution(24, 24)));
  }
}
