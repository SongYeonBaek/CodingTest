


import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution
{
public static void main(String args[]) throws Exception
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T =  Integer.parseInt(br.readLine());

	for(int test_case = 1; test_case <= T; test_case++){

		int N = Integer.parseInt(br.readLine());
		
		int a;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++){
			a = Integer.parseInt(br.readLine());
			if(list.contains(a)) {
				list.remove(list.indexOf(a));
			}
			else {
				list.add(a);
			}
		}                
		System.out.printf("#%d %d \n",test_case, list.size() );
	}
}
}