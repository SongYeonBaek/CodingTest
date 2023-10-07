#include <iostream>

using namespace std;

int N;
int arr[1001];

int main() {
    cin >> N;

    arr[1] =1;
    arr[2] =2;
    for (auto i=3;i<=N;i++)
        arr[i] = (arr[i-2] + arr[i-1]) %10007;

    cout << arr[N];
}