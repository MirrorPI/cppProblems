import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> answer = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (char ch : myStr.toCharArray()) {
            if (ch == 'a' || ch == 'b' || ch == 'c') {
                if (!word.isEmpty()) {
                    answer.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(ch);
            }
        }

        // 문자열 마지막에 남아 있는 단어 처리
        if (!word.isEmpty()) {
            answer.add(word.toString());
        }

        if (answer.isEmpty()) {
            return new String[]{"EMPTY"};
        }

        return answer.toArray(new String[0]);
    }
}