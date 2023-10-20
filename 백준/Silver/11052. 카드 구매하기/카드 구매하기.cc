#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;
    
    int arr[n+1] = {0, };
    for(int i=1; i<=n; i++){
        cin >> arr[i];
    }
    
    int dp[n+1] = {0, };
    
    dp[0] = arr[0] = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            dp[i] = max(dp[i], dp[i - j] + arr[j]);
        }
    }
    cout << dp[n] << endl;
    
    return 0;
    
}