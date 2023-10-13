#include <iostream>

using namespace std;

int main()
{
    int arr[1001][10];
    
    
    for(int i=0; i<10; i++){
        arr[0][i] = 1;
    }
    
    
    for(int i=0; i<1001; i++){
        arr[i][0] = 1;
    }
    
    for(int i=1; i<1001; i++){
        for(int j=1; j<10; j++){
            arr[i][j] = (arr[i][j-1] + arr[i-1][j]) % 10007;
        }
    }
    
    int n;
    cin >> n;
    
    int sum=0;
    for(int i=0; i<10; i++){
        sum += arr[n-1][i];
    }
    
    cout << sum %10007 << "\n";

    return 0;
}