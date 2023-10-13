#include <iostream>

using namespace std;

#define MAX 1000000000

int main()
{
    int arr[100][10];
    
    arr[0][0] = 0;
    for(int i=1; i<10; i++){
        arr[0][i] = 1;
    }
    
    for(int i=1; i<100; i++){
        for(int j=0; j<10; j++){
            if(j == 0) arr[i][j] = arr[i-1][1] % MAX;
            else if(j == 9) arr[i][j] = arr[i-1][8] % MAX;
            else arr[i][j] = (arr[i-1][j-1]+ arr[i-1][j+1]) % MAX;
        }
    }
    
    int n;
    cin >> n;
    
    int sum=0;
    for(int i=0; i<10; i++){
        sum += arr[n-1][i];
        sum %= MAX;
    }
    
    cout << sum % MAX<< "\n";

    return 0;
}