import java.util.*;

class Solution {
        public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;

        // 네오가 기억한 멜로디를 치환한다.
        m = changeCode(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String music = changeCode(parts[3]);

            // 재생된 시간 계산
            int startHour = Integer.parseInt(start.split(":")[0]);
            int startMinute = Integer.parseInt(start.split(":")[1]);
            int endHour = Integer.parseInt(end.split(":")[0]);
            int endMinute = Integer.parseInt(end.split(":")[1]);
            int playingTime = (endHour - startHour) * 60 + (endMinute - startMinute);

            // 음악 문자열 생성
            StringBuilder musicCode = new StringBuilder();
            for (int j = 0; j < playingTime; j++) {
                musicCode.append(music.charAt(j % music.length()));
            }

            // 멜로디가 포함된 곡을 찾기
            if (musicCode.toString().contains(m)) {
                if (playingTime > maxTime) {
                    maxTime = playingTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    // #이 붙은 음을 치환하는 함수
    public static String changeCode(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");
        code = code.replaceAll("B#", "b");

        return code;
    }

}
