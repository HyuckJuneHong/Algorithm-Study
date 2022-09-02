package programmers.kakao인턴쉽;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public String solution(String[] survey, int[] choices) {

        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 0);
        map.put("N", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("R", 0);
        map.put("T", 0);

        for (int i=0; i<survey.length; i++){

            if(survey[i].charAt(0) == 'A'){
                if(choices[i] == 1){
                    map.put("A", map.get("A") + 3);
                }else if(choices[i] == 2){
                    map.put("A", map.get("A") + 2);
                }else if(choices[i] == 3){
                    map.put("A", map.get("A") + 1);
                }else if(choices[i] == 5){
                    map.put("N", map.get("N") + 1);
                }else if(choices[i] == 6){
                    map.put("N", map.get("N") + 2);
                }else if(choices[i] == 7){
                    map.put("N", map.get("N") + 3);
                }
            }else if (survey[i].charAt(0) == 'N'){
                if(choices[i] == 1){
                    map.put("N", map.get("N") + 3);
                }else if(choices[i] == 2){
                    map.put("N", map.get("N") + 2);
                }else if(choices[i] == 3){
                    map.put("N", map.get("N") + 1);
                }else if(choices[i] == 5){
                    map.put("A", map.get("A") + 1);
                }else if(choices[i] == 6){
                    map.put("A", map.get("A") + 2);
                }else if(choices[i] == 7){
                    map.put("A", map.get("A") + 3);
                }
            }else if (survey[i].charAt(0) == 'C'){
                if(choices[i] == 1){
                    map.put("C", map.get("C") + 3);
                }else if(choices[i] == 2){
                    map.put("C", map.get("C") + 2);
                }else if(choices[i] == 3){
                    map.put("C", map.get("C") + 1);
                }else if(choices[i] == 5){
                    map.put("F", map.get("F") + 1);
                }else if(choices[i] == 6){
                    map.put("F", map.get("F") + 2);
                }else if(choices[i] == 7){
                    map.put("F", map.get("F") + 3);
                }
            }else if (survey[i].charAt(0) == 'F'){
                if(choices[i] == 1){
                    map.put("F", map.get("F") + 3);
                }else if(choices[i] == 2){
                    map.put("F", map.get("F") + 2);
                }else if(choices[i] == 3){
                    map.put("F", map.get("F") + 1);
                }else if(choices[i] == 5){
                    map.put("C", map.get("C") + 1);
                }else if(choices[i] == 6){
                    map.put("C", map.get("C") + 2);
                }else if(choices[i] == 7){
                    map.put("C", map.get("C") + 3);
                }
            }else if (survey[i].charAt(0) == 'J'){
                if(choices[i] == 1){
                    map.put("J", map.get("J") + 3);
                }else if(choices[i] == 2){
                    map.put("J", map.get("J") + 2);
                }else if(choices[i] == 3){
                    map.put("J", map.get("J") + 1);
                }else if(choices[i] == 5){
                    map.put("M", map.get("M") + 1);
                }else if(choices[i] == 6){
                    map.put("M", map.get("M") + 2);
                }else if(choices[i] == 7){
                    map.put("M", map.get("M") + 3);
                }
            }else if (survey[i].charAt(0) == 'M'){
                if(choices[i] == 1){
                    map.put("M", map.get("M") + 3);
                }else if(choices[i] == 2){
                    map.put("M", map.get("M") + 2);
                }else if(choices[i] == 3){
                    map.put("M", map.get("M") + 1);
                }else if(choices[i] == 5){
                    map.put("J", map.get("J") + 1);
                }else if(choices[i] == 6){
                    map.put("J", map.get("J") + 2);
                }else if(choices[i] == 7){
                    map.put("J", map.get("J") + 3);
                }

            }else if (survey[i].charAt(0) == 'R'){
                if(choices[i] == 1){
                    map.put("R", map.get("R") + 3);
                }else if(choices[i] == 2){
                    map.put("R", map.get("R") + 2);
                }else if(choices[i] == 3){
                    map.put("R", map.get("R") + 1);
                }else if(choices[i] == 5){
                    map.put("T", map.get("T") + 1);
                }else if(choices[i] == 6){
                    map.put("T", map.get("T") + 2);
                }else if(choices[i] == 7){
                    map.put("T", map.get("T") + 3);
                }

            }else if (survey[i].charAt(0) == 'T'){
                if(choices[i] == 1){
                    map.put("T", map.get("T") + 3);
                }else if(choices[i] == 2){
                    map.put("T", map.get("T") + 2);
                }else if(choices[i] == 3){
                    map.put("T", map.get("T") + 1);
                }else if(choices[i] == 5){
                    map.put("R", map.get("R") + 1);
                }else if(choices[i] == 6){
                    map.put("R", map.get("R") + 2);
                }else if(choices[i] == 7){
                    map.put("R", map.get("R") + 3);
                }
            }
        }

        if(map.get("R") >= map.get("T")){
            answer += "R";
        }else{
            answer += "T";
        }

        if(map.get("C") >= map.get("F")){
            answer += "C";
        }else{
            answer += "F";
        }

        if(map.get("J") >= map.get("M")){
            answer += "J";
        }else{
            answer += "M";
        }

        if(map.get("A") >= map.get("N")){
            answer += "A";
        }else{
            answer += "N";
        }

        return answer;
    }
}
