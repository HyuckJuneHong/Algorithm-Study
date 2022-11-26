import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n+1];
        int cnt = 0;
        Arrays.fill(arr, 0);

        for(int i=2; i<=n; i++){
            if(arr[i]==0){
                cnt++;
                for(int j=i; j<=n; j+=i){
                    arr[j] = 1;
                }
            }
        }


        stringBuilder.append(cnt);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}