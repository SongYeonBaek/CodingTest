#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    
    //배열 입력받기
    int arr[301];
    for(int i=1; i<=n; i++){
        cin >> arr[i];
    }
    
    //계단의 최댓값을 저장하기 위한 배열
    int dp[301];
    
    dp[1] = arr[1]; //1번째 계단까지의 최댓값: 1번
    dp[2] = arr[1] + arr[2]; //2번째 계단까지의 최댓값: 1번+2번 
    dp[3] = max(arr[1]+arr[3], arr[2]+arr[3]); //3번째 계단까지의 최댓값: 1번+3번 or 2번+3번
    
    //4번째 계단부터는 점화식
    for(int i=4; i<=n; i++){
        dp[i] = max(dp[i-2] + arr[i], dp[i-3]+arr[i-1]+arr[i]);
    }
    
    cout << dp[n] << "\n";
    
    return 0;
}