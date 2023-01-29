class Solution {
    /**
     * 크기가 n인 마름모 => n인 막대가 1칸 격차를 두고 n행으로 나열된 형태
     * 회전/대칭으로 다음과 같은 형태가 나와도 마름모
     * 중복되어 사용 가능
     *
     *       [0,1] [0,2]
     * [1,0] [1,1]
     *
     *             [0,2] [0,3] [0,4]
     *       [1,1] [1,2] [1,3]
     * [2,0] [2,1] [2,2]
     *
     *             [0,3]
     *       [1,2] [1,3]
     * [2,1] [2,2] [2,3]
     * [3,1] [3,2]
     * [4,1]
     *
     * DP? 각 칸마다 번호가 다른데..
     * DFS?
     * 마름모를 어떻게 찾을 것인가?
     * 직사각형을 찾은 다음 모서리를 제외한 칸을 검사?
     *
     * @param grid : 격자를 의미하는 배열
     * @return : 가장 큰 마름모 크기와 개수 [크기, 갯수]
     */
    public static int[] solution(int[][] grid) {
        int[] answer = {};
        int size = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                for(int k=1; k<=grid.length/2; k++){
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(solution(arr)[0] + " " + solution(arr)[1]);
    }
}