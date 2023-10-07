#include <iostream>
using namespace std;

int main()
{
    int arr[11] = {0, 1, 2, 4, };
    for(int i=4; i<=10; i++){
        arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
    }
    
    int T, n;
    cin >>  T;

    
    for(int i=0; i<T; i++){
        cin >> n;
        cout << arr[n] << "\n";
    }

    return 0;
}