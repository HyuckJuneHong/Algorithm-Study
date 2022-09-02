package programmers.level2.kakao;

public class 문자열압축 {
    public static int solution(String s) {
        int answer = s.length();

        //패턴 체크
        for(int i=1; i<s.length()+1; i++){
            int count = 1;                       //압축 횟수
            String target = s.substring(0, i);   //패턴
            String currentString = "";           //현재문자열
            StringBuilder stringBuilder = new StringBuilder(); //압축문자열

            for(int start=i; start<s.length()+1; start+=i){

                //현재 문자열
                if(start + i >= s.length()){
                    currentString = s.substring(start, s.length());
                }else{
                    currentString = s.substring(start, start + i);
                }

                //문자열 같은지 확인
                if(currentString.equals(target)){
                    count++;
                } else if (count == 1) {
                    stringBuilder.append(target);
                    target = currentString;
                }else{
                    stringBuilder.append(count).append(target);
                    target = currentString;
                    count = 1;
                }
            }

            if(i != target.length()){
                stringBuilder.append(target);
            }
            answer = Math.min(answer, stringBuilder.toString().length());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aawwddeeeeeeww"));
    }
}
