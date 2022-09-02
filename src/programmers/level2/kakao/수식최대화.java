package programmers.level2.kakao;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    public static long solution(String expression) {
        long answer = 0;

        String[] cul = expression.split("[0-9]+");
        String[] num = expression.split("\\*|\\-|\\+");

        List<String> culList = new ArrayList<>();
        List<Long> numList = new ArrayList<>();

        for(int i=1; i<cul.length; i++){
            culList.add(cul[i]);
            System.out.println("cul: " + culList.get(i-1));
        }
        for(String n : num){
            numList.add(Long.parseLong(n));
            System.out.println("num: " + n);
        }

        ArrayList<Long> numListTemp;
        ArrayList<String> culListTemp;


        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "*", "+", "-");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "*", "-", "+");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "+", "*", "-");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "+", "-", "*");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "-", "*", "+");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        numListTemp = new ArrayList<>(numList);
        culListTemp = new ArrayList<>(culList);
        calcul(numListTemp, culListTemp, "-", "+", "*");
        answer = Math.max(answer, Math.abs(numListTemp.get(0)));

        return answer;
    }

    public static void calcul(ArrayList<Long> numList, ArrayList<String> culList, String op1, String op2, String op3){
        finalCalcul(numList, culList, op1);
        finalCalcul(numList, culList, op2);
        finalCalcul(numList, culList, op3);
    }

    public static void finalCalcul(ArrayList<Long> numList, ArrayList<String> culList, String op){

        int i=0;
        int size = culList.size();

        while(i<size){
            if(op.equals(culList.get(i))){
                if(op.equals("*")){
                    numList.set(i, numList.get(i) * numList.get(i+1));
                }else if(op.equals("-")){
                    numList.set(i, numList.get(i) - numList.get(i+1));
                }else if(op.equals("+")){
                    numList.set(i, numList.get(i) + numList.get(i+1));
                }
                culList.remove(i);
                numList.remove(i+1);
                i--;
                size--;
            }
            i++;
        }

    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

}
