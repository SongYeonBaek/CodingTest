import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        String[] score = br.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < N; i++) {
            count += Integer.parseInt(score[i]);
        }

        System.out.println(count);
    }
}