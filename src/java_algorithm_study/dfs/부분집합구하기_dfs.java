package java_algorithm_study.dfs;

public class 부분집합구하기_dfs {

    static int n;
    static int[] check;

    public void dfs(int level){
        if(level==n+1){
            String temp = "";
            for(int i=1; i<=n; i++){
                if(check[i] == 1){
                    temp += (i + " ");
                }
            }
            if(temp.length() > 0){
                System.out.println(temp);
            }
        }else{
            check[level] = 1;
            dfs(level+1);

            check[level] = 0;
            dfs(level+1);
        }
    }

    public static void main(String[] args) {
        부분집합구하기_dfs T = new 부분집합구하기_dfs();
        n=3;
        check = new int[n+1];
        T.dfs(1);
    }
}
