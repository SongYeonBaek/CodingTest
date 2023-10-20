#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N;
    long long dp[101];

	cin >> N;
	
	//5번까지는 A를 하나 출력하는게 최대
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 3;
	dp[4] = 4;
	dp[5] = 5;
	
	//A를 하나 출력하는 것과 이전에 복사해둔 것을 붙여넣기 하는 것 비교
	for (int i = 6; i <= N; i++) {
		dp[i] = dp[i - 1] + 1;
		for (int j = 1; j <= i - 2; j++)
			dp[i] = max(dp[i], dp[i - 2 - j] * (j + 1));
	}
	cout << dp[N] << '\n';
	return 0;
}