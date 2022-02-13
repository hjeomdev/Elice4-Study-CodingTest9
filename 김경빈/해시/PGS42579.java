import java.util.*;

class PGS42579 {
	public static int[] solution(String[] genres, int[] plays) {

		int[] answer = {};

		Map<String, Integer> map = new HashMap<>();

		// Map에 장르별(key) 횟수(value) 더하기
		for(int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}

		// 내림차순을 위한 list
		ArrayList<String> genList = new ArrayList<>(map.keySet()); 
		Collections.sort(genList, (o1, o2) -> map.get(o2) - map.get(o1)); // 내림차순

		// 노래의 고유번호 리스트
		ArrayList<Integer> numList = new ArrayList<>();

		for(String g : genList) {
			int song1 = 0; // 1번곡 고유번호
			int song2 = 0; // 2번곡 고유번호
			int maxPlay = 0; // 재생횟수

			// 1번곡 찾기
			for(int i = 0; i < genres.length; i++) {
				if(g.equals(genres[i]) && maxPlay < plays[i]) {
					song1 = i;
					maxPlay = plays[i];
				}
			}

			maxPlay = 0;

			// 재생횟수 초기화, 2번곡 찾기(1번곡 제외)
			for(int i = 0; i < genres.length; i++) {
				if(g.equals(genres[i]) && maxPlay < plays[i] && song1 != i) {
					song2 = i;
					maxPlay = plays[i];
				}
			}

			numList.add(song1);

			// 장르에 곡이 한 개인 경우 제외
			if(maxPlay != 0) numList.add(song2);
		}

		answer = new int[numList.size()];

		for(int i = 0; i < answer.length; i++) {
			answer[i] = numList.get(i);
		}

		return answer;
	}


	public static void main(String args[]) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		int[] result = solution(genres, plays);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
