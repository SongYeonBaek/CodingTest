class Solution {
    public static int solution(int cacheSize, String[] cities) {

        // 대소문자 구분이 없으므로 모두 소문자로 변경
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        String[] cache = new String[cacheSize]; 	// 캐시
        int[] cache_access_time = new int[cacheSize]; 	// 캐시에 들어있는 값이 참조된 time

        // initialize
        for (int i = 0; i < cacheSize; i++) {
            cache[i] = "";
        }

        int time = 0;

        if(cacheSize==0){  // 캐시 용량이 0이면 예외처리
            return 5 * cities.length;
        }

        int cnt = 0; // 캐시 안에 들어있는 데이터의 수

        for (int i = 0; i < cities.length; i++) {
            String now = cities[i];
            boolean cached = false;

            // 캐시에 now가 존재하는지 확인
            for (int j = 0; j < cacheSize; j++) {
                if (cache[j].equals(now)) { // cache hit
                    time ++;
                    cache_access_time[j] = time;
                    cached = true;
                    break;
                }
            }

            if(!cached){ // cache miss
                time += 5;

                if(cnt < cacheSize){ // 캐시 안에 남은 공간이 있으면 넣는다.
                    cache[cnt] = now;
                    cache_access_time[cnt++] = time;

                }else{ // 남은 공간이 없다면 가장 오랫동안 참조되지 않은 위치(=참조 시간이 가장 작은 위치)를 찾아 변경한다
                    int min_idx = 0;
                    int min = time;

                    for (int j = 0; j < cacheSize; j++) {
                        if(min > cache_access_time[j]){
                            min = cache_access_time[j];
                            min_idx = j;
                        }
                    }

                    cache[min_idx] = now;
                    cache_access_time[min_idx] = time;
                }
            }
        }

        return time;
    }
}