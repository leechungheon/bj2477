//프로그래머스 과일장수
//사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때,
// 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 3, 1};//1 1 1 2 2 3 3
        Solution sol = new Solution(); // Solution 클래스의 인스턴스 생성
        sol.solution(3, 4, array);
    }
}
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            for (int i = 0; i < score.length - 1; i++) { // 버블 정렬 내림차순
                for (int j = i + 1; j < score.length; j++) {
                    if (score[i] < score[j]) {
                        tmp(score, i,j);
                    }
                }
            }
            int box = (score.length) / m;

            for (int j = 0; j < box; j++) {//4번반복, m이 3, score 길이 12
                int small = Integer.MAX_VALUE; // 초기화
                for (int i = m * j; i < (m * j) + m; i++) {//0,3,6,9
                    if (small > score[i]) {
                        small = score[i];
                    }
                }
                answer += small * m;
            }
            return answer;
        }

        public void tmp(int[] array, int a, int b) {
            int tmp;
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
    }