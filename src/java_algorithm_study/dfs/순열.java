package java_algorithm_study.dfs;

import java.util.Arrays;

public class 순열 {
    static int[] arr = {1, 3, 5};
    static int[] visited = {0, 0, 0};
    static int[] p = {0, 0, 0};

    private static void dfs(int idx) {
        if (idx == arr.length) {
            System.out.println(Arrays.toString(p));
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (visited[i] == 0) {
                visited[i]++;
                p[idx] = arr[i];
                dfs(idx+1);
                visited[i]--;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
    }
}
