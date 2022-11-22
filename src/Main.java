import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();

        String[] arr = new String[n];
        Arrays.fill(arr, "");

        int size = s.length()/4;
        int j=0, count=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#') arr[j] += "1";
            else arr[j] += "0";
            if(count==size) {
                j++;
                count=0;
            }
            count++;
        }
        for(int i=0; i<n; i++){
            c[i] = (char) Integer.parseInt(String.valueOf(Integer.parseInt(arr[i], 2)));
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}