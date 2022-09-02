package programmers.level2.DFS_BFS;

public class 타겟_넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int depth, int sum){

        int answer = 0;

        if(depth == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        answer += dfs(numbers, target, depth+1, sum+numbers[depth]);
        answer += dfs(numbers, target, depth+1, sum-numbers[depth]);

        return answer;
    }
}
