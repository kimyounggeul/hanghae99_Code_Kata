import java.util.ArrayList;
import java.util.List;


class Solution {

    // 모의고사
    // 문제 설명
    // 수포자는 수학을 포기한 사람의 준말입니다.
    // 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
    //
    // 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    // 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    // 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    //
    // 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    // 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    // input
    // int[] answer 정답
    //
    // 계산
    // 1번 5개씩 반복
    // 2번 8개씩 반복
    // 3번 10개씩 반복
    //
    // output
    // 가장 많이 문제를 많힌 사람 []
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] total = new int[3];

        // 수포자들 점수
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                total[0]++;
            }
            if (answers[i] == two[i % two.length]) {
                total[1]++;
            }
            if (answers[i] == three[i % three.length]) {
                total[2]++;
            }
        }

        // 최대 점수
        int max = Math.max(total[0], Math.max(total[1], total[2]));

        // 최대 점수를 가진 수포자 리스트
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < total.length; i++) {
            if (max == total[i]) {
                list.add(i + 1);
            }
        }

        // 리스트를 배열로
        int [] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}