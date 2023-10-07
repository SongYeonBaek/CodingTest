#include <iostream>
using namespace std;

int main()
{
    int x;
    cin >> x;
    
    if(x == 1 ||  x == 2) {
        cout << 1 << "\n";
        return 0;
    }
    
    // int arr[x+1] = {0, 1, 1, };
    
    long long arr[x+1];

    arr[1] = 1;
    arr[2] = 1;
    for(int i=3; i<=x; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }
    
    cout << arr[x] << "\n";
    
    return 0;
}