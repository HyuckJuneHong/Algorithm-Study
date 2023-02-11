package programmers.level3.dynamicProgramming;

public class 정수삼각형 {
    /**
     * 꼭대기 -> 바닥 경로 중 가장 큰 합
     * 아래 이동 -> 한칸 오른쪽 혹은 한칸 왼쪽 아래로만 가능
     * @param triangle : 삼각형 정보가 담긴 배열
     * @return 거쳐간 숫자 최댓값
     */
    public static int solution(int[][] triangle) {
        int answer = 0; //max

        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0)
                    triangle[i][j] += triangle[i-1][j];
                else if(i==j)
                    triangle[i][j] += triangle[i-1][j-1];
                else{
                    int right = triangle[i][j] + triangle[i-1][j];
                    int left = triangle[i][j] + triangle[i-1][j-1];
                    triangle[i][j] = Math.max(left, right);
                }
            }
        }

        int lastIndex = triangle.length-1;
        for(int i=0; i<triangle[lastIndex].length; i++){
            answer = Math.max(answer, triangle[lastIndex][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(solution(test));
    }
}
