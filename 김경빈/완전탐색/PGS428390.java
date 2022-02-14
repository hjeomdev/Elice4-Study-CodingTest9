import java.util.HashSet;
import java.util.Set;

class PGS42839 {
  public static int solution(String numbers) {
    int answer = 0;
    String[] strArr = numbers.split("");
    int[] numArr = new int[strArr.length];

    for (int i = 0; i < numArr.length; i++) {
      numArr[i] = Integer.parseInt(strArr[i]);
    }

    Set<Integer> set = new HashSet<>();
    // 1부터 끝까지 순열 조합
    for (int i = 1; i <= numArr.length; i++) {
      perm(strArr, 0, i, set);
    }

    answer = set.size();

    return answer;
  }

  public static void perm(String[] arr, int depth, int k, Set set) {
    if (depth == k) {
      print(arr, k, set);
      return;
    } else {
      for (int i = depth; i < arr.length; i++) {
        swap(arr, i, depth);
        perm(arr, depth + 1, k, set);
        swap(arr, i, depth);
      }
    }
  }

  public static void swap(String[] arr, int i, int j) {
    String temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // 연결
  public static void print(String[] arr, int k, Set set) {
    StringBuilder s = new StringBuilder();

    for (int i = 0; i < k; i++) {
      s.append(arr[i]);
    }

    primeNumber(set, s);
  }

  // 소수 판별
  public static void primeNumber(Set set, StringBuilder s) {
    int num = Integer.parseInt(String.valueOf(s));
    boolean prime = true;

    if (num <= 1) {
      return;
    }

    // 제곱근까지 나눠서 약수 확인
    for (int i = 2; i <= Math.sqrt(num); i++) {

      if (num % i == 0) {
        prime = false;
        break;
      }
    }

    if (prime) {
      set.add(num);
    }
  }

  public static void main(String args[]) {
    String number1 = "17";
    String number2 = "011";

    System.out.println(solution(number1));
    System.out.println(solution(number2));
  }
}
