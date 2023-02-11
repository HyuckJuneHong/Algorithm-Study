
class Solution {

    /**
     * 턴제 게임 2명 / 배열을 공유
     * 나의 턴 : 배열에서 0이 아닌 수 -> 고른 수에서 -1
     *
     * 팰린드롬 만들면 승리
     * @param queries
     * @return 첫 선수 승리 : 1 / 패배 : 0
     */
    public int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int sum = 0;
            for(int j=0; j<queries[i].length; j++){
                sum += queries[i][j];
            }
            if(sum%2 == 1){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }
}